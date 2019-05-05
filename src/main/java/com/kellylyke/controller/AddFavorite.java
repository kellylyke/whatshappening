package com.kellylyke.controller;

import com.kellylyke.entity.Preference;
import com.kellylyke.entity.User;
import com.kellylyke.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "add",
        urlPatterns = {"/add"}
)
/*
  servlet for adding favorite candidate to user preferences
  @author klyke
  */

public class AddFavorite extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDao = new GenericDao<>(User.class);
    private GenericDao<Preference> dao = new GenericDao<>(Preference.class);



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("firstName") + ' ' + req.getParameter("lastName");
        User user = userDao.getByPropertyEqual("username", req.getRemoteUser()).get(0);
        Preference newPreference = new Preference();
        newPreference.setShow(id);
        newPreference.setUser(user);
        newPreference.setCandidateName(name);
        user.addPreference(newPreference);
        dao.insert(newPreference);

        logger.debug(user.getPreferences());

        //RequestDispatcher dispatcher = req.getRequestDispatcher("/myAccount.jsp");
        resp.sendRedirect("myAccount");


    }

}
