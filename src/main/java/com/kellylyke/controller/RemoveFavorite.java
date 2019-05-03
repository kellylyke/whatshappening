package com.kellylyke.controller;


import com.kellylyke.entity.Preference;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "remove",
        urlPatterns = {"/remove"}
)
/*
  servlet for adding favorite candidate to user preferences
  @author klyke
  */

public class RemoveFavorite extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDao = new GenericDao<>(User.class);
    private GenericDao<Preference> dao = new GenericDao<>(Preference.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = userDao.getByPropertyEqual("username", req.getRemoteUser()).get(0);
        Set<Preference> preferences = user.getPreferences();
        for (Preference preference : preferences) {
            if (preference.getShow().equals(id)) {
                dao.delete(preference);
            }
        }

        // newPreference.setCandidateName(name);

        logger.debug(user.getPreferences());

        //RequestDispatcher dispatcher = req.getRequestDispatcher("/myAccount.jsp");
        resp.sendRedirect("myAccount");


    }

}