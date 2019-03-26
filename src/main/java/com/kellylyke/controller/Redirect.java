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
        name = "redirect",
        urlPatterns = {"/redirect"}
)

public class Redirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "index.jsp";

        resp.sendRedirect(url);

    }
}
