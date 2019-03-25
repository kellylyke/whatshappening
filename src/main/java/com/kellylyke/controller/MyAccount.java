package com.kellylyke.controller;

import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * servlet for getting/updating user account information
 * @author klyke
 */

@WebServlet(
        name = "myAccount",
        urlPatterns = {"/myAccount"}
)

public class MyAccount extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<User> userDao = new GenericDao<>(User.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDao.getByPropertyEqual("username", req.getRemoteUser());
        User user = users.get(0);

        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/myAccount.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.getById(Integer.parseInt(req.getParameter("id")));

        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        //user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        String newPassword = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
       if (newPassword.equals(confirmPassword)) {
           user.setPassword(newPassword);
       } else {
           //session.setAttribute("passwordError", )
       }
       // user.setPassword(req.getParameter("id"));

        userDao.saveOrUpdate(user);


    }


}
