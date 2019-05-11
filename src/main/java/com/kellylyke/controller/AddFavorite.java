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



/**
 * Servlet for adding candidate to watch list
 * @author klyke
 */
@WebServlet(
        name = "add",
        urlPatterns = {"/add"}
)

public class AddFavorite extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDao = new GenericDao<>(User.class);
    private GenericDao<Preference> dao = new GenericDao<>(Preference.class);

    /**
     * Sets the preference to the user's account
     *
     * @param req http request
     * @param resp http response
     * @throws ServletException any servlet exception
     * @throws IOException any io exception
     */
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

       try {
           resp.sendRedirect("myAccount");
       } catch (Exception e) {
           logger.error("Problem redirecting to account" + e);
        }

    }

}
