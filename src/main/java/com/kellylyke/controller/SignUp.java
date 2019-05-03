package com.kellylyke.controller;

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
import java.util.Date;
import java.util.List;

/**
 * servlet for signing up users
 * @author klyke
 */

@WebServlet(
        name = "signUp",
        urlPatterns = {"/signUp"}
)
public class SignUp extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = new User();
        PasswordHash ph = new PasswordHash();
        RequestDispatcher dispatcher;

        List<User> userList =  userDao.getByPropertyEqual("username", req.getParameter("username"));
        if (userList.size() > 0) {
            req.setAttribute("usernameTaken", "That username is not available. Please try another.");
            dispatcher = req.getRequestDispatcher("/signUpError.jsp");
        } else {
            user.setFirstName(req.getParameter("firstName"));
            user.setUsername(req.getParameter("username"));
            user.setLastName(req.getParameter("lastName"));
            user.setEmail(req.getParameter("email"));
            String hashedPassword = ph.sha256(req.getParameter("password"));
            user.setPassword(hashedPassword);
            user.setZipcode(Integer.parseInt(req.getParameter("zipcode")));
            logger.debug("User to be added: " + user);
            Role role = new Role();
            role.setUser(user);
            role.setRole("user");
            role.setDateCreated(new Date());
            user.addRole(role);
            userDao.insert(user);
            dispatcher = req.getRequestDispatcher("/signUpConfirmation.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
