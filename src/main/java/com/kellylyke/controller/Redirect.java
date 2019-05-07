package com.kellylyke.controller;


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
