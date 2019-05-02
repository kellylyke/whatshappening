package com.kellylyke.controller;

import com.kellylyke.entity.Preference;
import com.kellylyke.service.*;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import com.kellylyke.service.congress.MembersItem;
import com.kellylyke.service.finance.Contributors;
import com.kellylyke.service.finance.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "members",
        urlPatterns = {"/members"}
)
/*
  servlet for display member data from API
  @author klyke
 */
public class MemberDisplay extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDao = new GenericDao<>(User.class);
    private GenericDao<Preference> dao = new GenericDao<>(Preference.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get query parameter
        List<User> users = userDao.getByPropertyEqual("username", req.getRemoteUser());
        String id = req.getParameter("id");
        logger.info(id);
        if (users.size() > 0) {
            User user = users.get(0);
            Set<Preference> preferences = user.getPreferences();

            String onList = "no";
            Preference pref = new Preference(id, user);

            for (Preference preference : preferences) {
                if (preference.getShow().equals(id)) {
                    onList = "yes";
                }
            }

            logger.info(pref);
            logger.info(preferences);
            logger.info(onList);
            req.setAttribute("onList", onList);
        }

        MemberService memberService = new MemberService();

        FinanceService financeService = new FinanceService();
        MembersItem member = new MembersItem();
        try {
            member = memberService.getMemberByID(id);
           // logger.info(member);
            req.setAttribute("member", member);
        } catch (Exception e) {
            logger.error("Error getting member " + e);
        }

        if (member != null) {

            Contributors contributors = null;
            try {
                contributors = financeService.getFinancialDataForCandidate(id);
                req.setAttribute("contributors", contributors.getContributor());

            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

           // logger.info(contributors.getContributor());
           // req.setAttribute("contributors", contributors.getContributor());
        }

//        if (req.getRemoteUser() != null) {
//            req.setAttribute("user", req.getRemoteUser());
//        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/members.jsp");
        dispatcher.forward(req, resp);
    }



}
