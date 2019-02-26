package com.kellylyke.persistence;

import com.kellylyke.entity.Preference;
import java.util.List;
import static org.junit.Assert.*;
import com.kellylyke.entity.User;
import com.kellylyke.test.util.*;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Test class for the user dao
 *
 *@author klyke
 */
public class PreferenceDaoTest {

    PreferenceDao dao;

    /**
     * Sets up dao, creates fresh database
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new PreferenceDao();
    }

    /**
     * Tests get all users success.
     */
    @Test
    public void getAllPreferencesSuccess() {

        List<Preference> preferences = dao.getAllPreferences();
        Assert.assertEquals(4, preferences.size());
    }

    /**
     * Tests get all users success.
     */
    @Test
    public void updateSuccess() {
        String newPreference =  "Lincoln";
        Preference userToUpdate = dao.getById(3);
        userToUpdate.setShow(newPreference);
        dao.saveOrUpdate(userToUpdate);
        Preference retrievedPreference = dao.getById(3);
        Assert.assertEquals(newPreference, retrievedPreference.getShow());
    }

    /**
     * Verify successful retrieval of a user by id
     */
    @Test
    public void getByIdSuccess() {

        Preference retrievedPreference = dao.getById(1);
        Assert.assertEquals("Washington", retrievedPreference.getShow());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    public void insertSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(3);
        Preference newPreference = new Preference("Kennedy", user);
        user.addPreference(newPreference);

        int id = dao.insert(newPreference);
        assertNotEquals(0,id);

        Preference insertedPreference = dao.getById(id);

        Assert.assertEquals("Kennedy", insertedPreference.getShow());
        Assert.assertEquals("Monica", insertedPreference.getUser().getFirstName());

    }


    /**
     * Verify successful delete of user
     */
    @Test
    public void deleteSuccess() {
        dao.delete(dao.getById(2));
        Assert.assertNull(dao.getById(2));
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    public void getByPropertyEqualSuccess() {
        List<Preference> preferences = dao.getByPropertyEqual("show", "Lincoln");
        Assert.assertEquals(1, preferences.size());
        Assert.assertEquals(2, preferences.get(0).getId());
    }


    /**
     * Verify successful get by property (like match)
     */
    @Test
    public void getByPropertyLikeSuccess() {
        List<Preference> preferences = dao.getByPropertyLike("show", "j");
        Assert.assertEquals(2, preferences.size());
    }




}


