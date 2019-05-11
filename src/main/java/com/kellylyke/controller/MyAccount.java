package com.kellylyke.controller;

import com.kellylyke.entity.Preference;
import com.kellylyke.entity.Role;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import com.kellylyke.persistence.PasswordHash;

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
    private GenericDao<User> userDao = new GenericDao<>(User.class);

    /**
     *  Retrieves user account info and displays it to page
     *
     * @param req http request object
     * @param resp http response object
     * @throws ServletException any servlet exception
     * @throws IOException an io exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDao.getByPropertyEqual("username", req.getRemoteUser());
        User user = users.get(0);
        req.setAttribute("admin", checkIfAdmin(user));

        Set<Preference> preferences = user.getPreferences();
        req.setAttribute("user", user);
        req.setAttribute("preferences", preferences);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/myAccount.jsp");
        dispatcher.forward(req, resp);

    }

    /**
     * Updates account data from form post
     *
     * @param req the http request object
     * @param resp the htt resp object
     * @throws ServletException any servlet exception
     * @throws IOException any io exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.getById(Integer.parseInt(req.getParameter("id")));


        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));

        user.setEmail(req.getParameter("email"));
        user.setZipcode(Integer.parseInt(req.getParameter("zipcode")));
        String newPassword = req.getParameter("password");

        if (!newPassword.equals(req.getParameter("confirmPassword"))) {
            req.getRequestDispatcher("/updateError.jsp");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/updateError.jsp");
            dispatcher.forward(req, resp);
        } else {
            userDao.saveOrUpdate(user);
            String hashedPassword = PasswordHash.sha256(newPassword);
            user.setPassword(hashedPassword);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/updateSuccess.jsp");
            dispatcher.forward(req, resp);
        }


    }

    /**
     * Determines if user has admin role
     *
     * @param user user logged in
     * @return if admin
     */
    private boolean checkIfAdmin(User user) {
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
