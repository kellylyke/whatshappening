package com.kellylyke.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kellylyke.service.MemberService;
import com.kellylyke.service.congress.MembersItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(
        name = "search",
        urlPatterns = {"/search"}
)

public class Search extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchTerm = req.getParameter("searchTerm");

        MemberService service = new MemberService();


        try {
            List<MembersItem> members = new ArrayList<MembersItem>();
            members = service.getSpecificMember(searchTerm);
            req.setAttribute("members", members);


        } catch (Exception e) {
            logger.error("Error getting member " + e);
        }


        //req.setAttribute("members", members);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchResults.jsp");
        dispatcher.forward(req, resp);


    }
}

