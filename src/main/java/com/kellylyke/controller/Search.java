package com.kellylyke.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import com.kellylyke.service.MemberService;
import com.kellylyke.service.congress.MembersItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(
        name = "search",
        urlPatterns = {"/search"}
)

public class Search extends HttpServlet {
    Properties properties = new Properties();
    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchTerm = req.getParameter("searchTerm");

        logger.info(searchTerm);
        loadProperties();
        String key = properties.getProperty("propublica_key");
        MemberService service = new MemberService();
        MembersItem member = new MembersItem();
        try {
            member = service.getSpecificMember(searchTerm);
            req.setAttribute("member", member);
        } catch (Exception e) {
            logger.error("Error getting member" + e);
            //probably say no results found or something??
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/members.jsp");
        dispatcher.forward(req, resp);
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/apiKey.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
            e.printStackTrace();
        }
    }
}
