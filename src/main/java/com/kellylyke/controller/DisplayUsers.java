package com.kellylyke.controller;

import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * servlet for getting all users
 * @author klyke
 */

@WebServlet(
        name = "allUsers",
        urlPatterns = {"/allUsers"}
)

public class DisplayUsers extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        List<User> users = new ArrayList<>();
        try {
            users = userDao.getAll();
            logger.debug(users);
        } catch (Exception e) {
            logger.error("Error getting all users" + e);
        }
        req.setAttribute("users", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/allUsers.jsp");
        dispatcher.forward(req, resp);
    }

}
