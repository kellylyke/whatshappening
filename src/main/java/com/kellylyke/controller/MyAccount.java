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
    private static final String REDIRECT_URL = "/myAccount.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDao.getByPropertyEqual("username", req.getRemoteUser());
        User user = users.get(0);
        req.setAttribute("admin", checkIfAdmin(user));

        Set<Preference> preferences = user.getPreferences();
        req.setAttribute("user", user);
        req.setAttribute("preferences", preferences);
        // logger.debug(preferences);
        RequestDispatcher dispatcher = req.getRequestDispatcher(REDIRECT_URL);
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.getById(Integer.parseInt(req.getParameter("id")));
        RequestDispatcher dispatcher = null;

        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));

        user.setEmail(req.getParameter("email"));
        String newPassword = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");


        if (newPassword.equals(confirmPassword)) {
            String hashedPassword = PasswordHash.sha256(newPassword);
            user.setPassword(hashedPassword);
            req.getRequestDispatcher(REDIRECT_URL);
        } else {
            req.setAttribute("passwordError", "Your passwords did not match. Try again.");
            dispatcher = req.getRequestDispatcher(REDIRECT_URL);
        }

        userDao.saveOrUpdate(user);
        try {
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("Problem forwarding: " + e);
        }


    }

    public boolean checkIfAdmin(User user) {
        boolean admin = false;
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (role.getRole().equals("admin")) {
                admin = true;
            }

        }
        return admin;
    }



}
