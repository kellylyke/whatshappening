package com.kellylyke.persistence;

import com.kellylyke.entity.Preference;
import java.util.List;

import static org.junit.Assert.*;
import com.kellylyke.entity.User;
import com.kellylyke.test.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Test class for the preference dao
 *
 *@author klyke
 */
public class PreferenceDaoTest {

    GenericDao dao;
    GenericDao userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());


     /**
     * Sets up dao, creates fresh database
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao(Preference.class);
        userDao = new GenericDao(User.class);

    }

    /**
     * Tests get all preferences success.
     */
    @Test
    public void getAllPreferencesSuccess() {

        List<Preference> preferences = dao.getAll();
        assertTrue(preferences.size() > 0);
        //assertEquals(5, preferences.size());
    }

    /**
     * Tests update user preferences success.
     */
    @Test
    public void updateSuccess() {
        String newPreference =  "Lincoln";
        Preference userToUpdate = (Preference)dao.getById(3);
        userToUpdate.setShow(newPreference);
        dao.saveOrUpdate(userToUpdate);
        Preference retrievedPreference = (Preference)dao.getById(3);
        assertEquals(newPreference, retrievedPreference.getShow());

    }

    /**
     * Verify successful retrieval of a preference by id
     */
    @Test
    public void getByIdSuccess() {

        Preference retrievedPreference = (Preference)dao.getById(1);
        assertEquals("Washington", retrievedPreference.getShow());
    }

    /**
     * Verify successful insert of a preference
     */
    @Test
    public void insertSuccess() {
        User user = (User)userDao.getById(3);
        Preference newPreference = new Preference("Kennedy", user);
        user.addPreference(newPreference);

        int id = dao.insert(newPreference);
        assertNotEquals(0,id);

        Preference insertedPreference = (Preference)dao.getById(id);

        assertEquals(newPreference,insertedPreference);
    }

    /**
     * Verify successful delete of preference
     */
    @Test
    public void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));

    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    public void getByPropertyEqualSuccess() {
        List<Preference> preferences = dao.getByPropertyEqual("show", "Lincoln");
        assertEquals(1, preferences.size());
        assertEquals(2, preferences.get(0).getId());
    }

    /**
     * verifies removal of preference
     */
    @Test
    public void removeSuccess() {
        User user = (User)userDao.getById(3);
        Preference preferenceToRemove = (Preference)dao.getById(1);
        user.removePreference(preferenceToRemove);
        dao.delete(preferenceToRemove);
        assertNull(dao.getById(1));
        assertEquals(1, user.getPreferences().size());

    }


}


