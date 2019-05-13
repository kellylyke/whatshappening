package com.kellylyke.controller;

import com.kellylyke.entity.Preference;
import com.kellylyke.service.*;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import com.kellylyke.service.congress.MembersItem;
import com.kellylyke.service.finance.Contributors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * The servlet that displays selected congress member with financial data
 */
@WebServlet(
        name = "members",
        urlPatterns = {"/members"}
)

public class MemberDisplay extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDao = new GenericDao<>(User.class);
    private Contributors contributors;

    /**
     * Calls to apis go get congress member and financial data
     *
     * @param req http request object
     * @param resp http response object
     * @throws ServletException servlet exception
     * @throws IOException read/write exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDao.getByPropertyEqual("username", req.getRemoteUser());
        User user = new User();
        String id = req.getParameter("id");

        if (users.size() > 0) {
            user = users.get(0);
        }

        MembersItem member = getMember(id);
            req.setAttribute("member", member);

        if (member != null) {
            contributors = getContributorForCandidate(id);
            req.setAttribute("contributors", contributors.getContributor());
        }


        req.setAttribute("onList", checkIfOnList(user, id));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/members.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * gets congress member data from api
     * @param id candidate's id
     * @return member data
     */
    private MembersItem getMember(String id) {
        MemberService memberService = new MemberService();
        MembersItem member = new MembersItem();

        try {
            member = memberService.getMemberByID("000");

        } catch (Exception e) {
            logger.error("Error getting member " + e);
        }
        return member;
    }

    /**
     * calls api to get financial data for candidate
     *
     * @param id candidate's id
     * @return list of contributors and values
     */
    private Contributors getContributorForCandidate(String id) {

        FinanceService financeService = new FinanceService();
        try {
            contributors = financeService.getFinancialDataForCandidate(id);

        } catch (Exception e) {
            logger.error("Error getting contributors " + e);
        }
        return contributors;

    }

    /**
     * checks if user has added current member to list already
     *
     * @param user current user logged in
     * @param id id of candidate
     * @return if selected candidate already on user's list
     */
    private String checkIfOnList(User user, String id) {
        Set<Preference> preferences = user.getPreferences();
        String onList = "no";
        for (Preference preference : preferences) {
            if (preference.getShow().equals(id)) {
                onList = "yes";
            }
        }
        return onList;
    }



}
