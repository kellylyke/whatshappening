package com.kellylyke.controller;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "members",
        urlPatterns = {"/members"}
)
/**
 * servlet for display member data from API
 * @author klyke
 */
public class MemberDisplay extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get query parameter

        MemberService memberService = new MemberService();

        FinanceService financeService = new FinanceService();
        List<MembersItem> member = new ArrayList<MembersItem>();
        try {
            member = memberService.getSpecificMember("Baldwin");
           // logger.info(member);
            req.setAttribute("member", member);
        } catch (Exception e) {
            logger.error("Error getting member " + e);
        }
//
//        if (member != null) {
//            String id = member.getCrpId();
//
//            Contributors contributors =  financeService.getFinancialDataForCandidate(id);
//
//            logger.info(contributors.getContributor());
//            req.setAttribute("contributors", contributors.getContributor());
//
//        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/members.jsp");
        dispatcher.forward(req, resp);
    }



}
