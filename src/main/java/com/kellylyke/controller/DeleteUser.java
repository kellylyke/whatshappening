package com.kellylyke.controller;


import com.kellylyke.entity.Preference;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

import static com.kellylyke.persistence.SessionFactoryProvider.getSessionFactory;

@WebServlet(
        name = "delete",
        urlPatterns = {"/delete"}
)

public class DeleteUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDao = new GenericDao<>(User.class);
    private GenericDao<Preference> dao = new GenericDao<>(Preference.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int userID = Integer.parseInt(id);
        User user = userDao.getById(userID);
        String username = user.getUsername();
      //  logger.debug(user);
        userDao.delete(user);

        HttpSession session = req.getSession();

        session.setAttribute("deleteSuccess", "User " + username + " was deleted!");

        //resp.sendRedirect("allUsers");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allUsers");
        dispatcher.forward(req, resp);


    }

}