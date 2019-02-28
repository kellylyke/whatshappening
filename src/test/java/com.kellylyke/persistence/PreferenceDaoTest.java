package com.kellylyke.persistence;

import com.kellylyke.entity.Preference;
import java.util.List;

import static org.junit.Assert.*;
import com.kellylyke.entity.User;
import com.kellylyke.test.util.*;

import org.hibernate.Session;
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

    GenericDao<Preference> dao;
    GenericDao<User> userDao;

    /**
     * Sets up dao, creates fresh database
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao<>(Preference.class);
        userDao = new GenericDao<>(User.class);
    }

    /**
     * Tests get all preferences success.
     */
    @Test
    public void getAllPreferencesSuccess() {

        List<Preference> preferences = dao.getAll();
        assertEquals(4, preferences.size());
    }

    /**
     * Tests update user preferences success.
     */
    @Test
    public void updateSuccess() {
        String newPreference =  "Lincoln";
        Preference userToUpdate = dao.getById(3);
        userToUpdate.setShow(newPreference);
        dao.saveOrUpdate(userToUpdate);
        Preference retrievedPreference = dao.getById(3);
        assertEquals(newPreference, retrievedPreference.getShow());
    }

    /**
     * Verify successful retrieval of a preference by id
     */
    @Test
    public void getByIdSuccess() {

        Preference retrievedPreference = dao.getById(1);
        assertEquals("Washington", retrievedPreference.getShow());
    }

    /**
     * Verify successful insert of a preference
     */
    @Test
    public void insertSuccess() {
        User user = userDao.getById(3);
        Preference newPreference = new Preference("Kennedy", user);
        user.addPreference(newPreference);

        int id = dao.insert(newPreference);
        assertNotEquals(0,id);

        Preference insertedPreference = dao.getById(id);

        assertEquals("Kennedy", insertedPreference.getShow());
        assertEquals("Monica", insertedPreference.getUser().getFirstName());

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
        User user = userDao.getById(3);
        Preference preferenceToRemove = dao.getById(1);
        user.removePreference(preferenceToRemove);
        dao.delete(preferenceToRemove);
        assertNull(dao.getById(1));
        assertEquals(0, user.getPreferences().size());

    }


}


