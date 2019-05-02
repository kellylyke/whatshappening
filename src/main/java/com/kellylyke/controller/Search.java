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
import java.util.Properties;

import com.kellylyke.service.FinanceService;
import com.kellylyke.service.MemberService;
import com.kellylyke.service.PropertiesLoader;
import com.kellylyke.service.congress.MembersItem;
import com.kellylyke.service.finance.Contributors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(
        name = "search",
        urlPatterns = {"/search"}
)

public class Search extends HttpServlet implements PropertiesLoader {
    private Properties properties = new Properties();
    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String unformattedTerm = req.getParameter("searchTerm");
        String searchTerm = unformattedTerm.substring(0, 1).toUpperCase() + unformattedTerm.substring(1).toLowerCase();

        //prop = getProperties();
        MemberService service = new MemberService();
        List<MembersItem> members = new ArrayList<MembersItem>();
        try {
            members = service.getSpecificMember(searchTerm);
            logger.info(members);
            req.setAttribute("members", members);
//            if (member != null) {
//                String id = member.getCrpId();
//                FinanceService financeService = new FinanceService();
//                Contributors contributors =  financeService.getFinancialDataForCandidate(id);
//                req.setAttribute("contributors", contributors.getContributor());
//
//            }
        } catch (Exception e) {
            logger.error("Error getting member " + e);
            //probably say no results found or something??
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchResults.jsp");
        dispatcher.forward(req, resp);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        if (req.getParameter("submit").equals("search")) {
//            req.setAttribute("users", userData.getUsersByLastName(req.getParameter("searchTerm")));
//        } else {
//            req.setAttribute("users", userData.getAllUsers());
//        }
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
//        dispatcher.forward(req, resp);
//    }

//
//
//    private void loadProperties() {
//        properties = new Properties();
//        try {
//            properties.load(this.getClass().getResourceAsStream("/apiKey.properties"));
//        } catch (IOException ioe) {
//            logger.error("Database.loadProperties()...Cannot load the properties file");
//            ioe.printStackTrace();
//        } catch (Exception e) {
//            logger.error("Database.loadProperties()..." + e);
//            e.printStackTrace();
//        }
//    }

    /**
     * Loads properties for the application
     *
     * @return properties for the application
     */
    private Properties getProperties() {
        // Load properties
        Properties prop = new Properties();

        try {
            prop = loadProperties("/apiKey.properties");
        } catch (IOException ioException) {
            logger.error(ioException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        return prop;
    }
}
