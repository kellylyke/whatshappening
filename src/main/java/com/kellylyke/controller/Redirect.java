package com.kellylyke.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * servlet redirects to home page
 * @author klyke
 */

@WebServlet(
        name = "redirect",
        urlPatterns = {"/redirect"}
)

public class Redirect extends HttpServlet {

    /**
     * redirects to index
     * @param req http request object
     * @param resp http response object
     * @throws ServletException servlet exception
     * @throws IOException read/write exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "index.jsp";

        resp.sendRedirect(url);

    }
}
