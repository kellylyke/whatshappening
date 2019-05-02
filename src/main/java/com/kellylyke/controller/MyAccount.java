package com.kellylyke.controller;

import com.kellylyke.entity.Preference;
import com.kellylyke.entity.Role;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import com.kellylyke.persistence.PasswordHash;
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
import java.util.Set;


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
    private GenericDao<User> userDao = new GenericDao<>(User.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDao.getByPropertyEqual("username", req.getRemoteUser());
        User user = users.get(0);
        Set<Preference> preferences = user.getPreferences();
        req.setAttribute("user", user);
        req.setAttribute("preferences", preferences);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/myAccount.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.getById(Integer.parseInt(req.getParameter("id")));
        PasswordHash ph = new PasswordHash();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));

        user.setEmail(req.getParameter("email"));
        String newPassword = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (newPassword.equals(confirmPassword)) {
            String hashedPassword = ph.sha256(newPassword);
            user.setPassword(hashedPassword);
        } else {
            //session.setAttribute("passwordError", )
       }

        userDao.saveOrUpdate(user);

    }


}
