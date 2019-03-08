package com.kellylyke.controller;


import com.kellylyke.entity.Role;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet for signing up users
 * @author klyke
 */

@WebServlet(
        name = "signUp",
        urlPatterns = {"/signUp"}
)
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userDao = new GenericDao<>(User.class);
       /* Role role = new Role();
        role.setUser(user);
        role.setRole("user");
        userDao.addRole(role);*/
    }
}
