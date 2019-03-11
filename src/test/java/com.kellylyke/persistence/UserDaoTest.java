package com.kellylyke.persistence;

import com.kellylyke.entity.Preference;
import com.kellylyke.entity.Role;
import com.kellylyke.entity.User;
import java.lang.Integer;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import com.kellylyke.test.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




/**
 * Test class for the user dao
 *
 *@author klyke
 */
public class UserDaoTest {

    GenericDao dao;
    List<User> users;

    /**
     * Sets up dao, creates fresh database
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");


       dao = new GenericDao(User.class);
       users = dao.getAll();
    }

    /**
     * Tests get all users success.
     */
    @Test
    public void getAllUsersSuccess() {

        List<User> users = dao.getAll();
        assertEquals(5, users.size());
    }

    /**
     * Tests get all users success.
     */
    @Test
    public void userUpdateSuccess() {
        /*String newLastName =  "Geller-Bing";
        User userToUpdate = (User)dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById(3);
        assertEquals(userToUpdate, retrievedUser);*/

      ;
        User  user = users.get(2);
        int id = user.getId();
        String newLastName = "Geller-Bing";


        user.setLastName(newLastName);

        dao.saveOrUpdate(user);


        User retrievedUser = (User)dao.getById(3);

        assertEquals(user, retrievedUser);
    }

    /**
     * Verify successful retrieval of a user by id
     */
    @Test
    public void getByIdSuccess() {
        User retrievedUser = new User();
        retrievedUser = (User)dao.getById(4);
        assertEquals("Ross", retrievedUser.getFirstName());
        assertEquals("Geller", retrievedUser.getLastName());
        assertEquals("drgeller", retrievedUser.getUsername());
        assertEquals(10032, retrievedUser.getZipcode());
        assertEquals("rgeller@phd.edu", retrievedUser.getEmail());
        assertEquals("dinosrock", retrievedUser.getPassword());

    }

    /**
     * Verify successful insert of a user
     */
    @Test
    public void insertSuccess() {
        User newUser = new User("Joey", "Tribbiani", "joey", 90210, "drakeramoray@daysofourlives.com", "pizza");
        Role role = new Role();
        role.setRole("admin");
        role.setDateCreated(new Date());
        role.setUser(newUser);
        newUser.addRole(role);

        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(id);

        assertTrue(insertedUser.getId() > 0);

        assertEquals(newUser, insertedUser);
        //assertEquals(1, insertedUser.getRoles().size());
       // assertTrue(insertedUser.getRoles().contains(role));




    }

    /**
     * Verify successful insert of a user and an preference
     */
    @Test
    public void insertWithPreferenceSuccess() {

        String show = "Washington";
        User newUser = new User("Joey", "Tribbiani", "joe", 90210, "drakeramoray@daysofourlives.com", "pizza");
        Role role = new Role();
        role.setRole("admin");
        role.setDateCreated(new Date());
        role.setUser(newUser);
        newUser.addRole(role);
        Preference preference = new Preference(show, newUser);
        newUser.addPreference(preference);

        int id = dao.insert(newUser);
        assertNotEquals(0, id);

        User insertedUser = (User)dao.getById(id);
        assertNotNull(insertedUser);

        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getPreferences().size());


    }


    /**
     * Verify successful delete of user
     */
    @Test
    public void deleteSuccess() {
       /* User userToDelete = new User();
        userToDelete.setUser(dao.getById(5));
        dao.delete(dao.getById(5));
        User deletedUser = new User();
        deletedUser = (User)dao.getById(5);
        assertNull(deletedUser);*/

        int sizeBeforeDelete = users.size();
        User userToDelete = users.get(4);
        int id = userToDelete.getId();
        dao.delete(userToDelete);
        int sizeAfterDelete = dao.getAll().size();
        User deletedUser = (User) dao.getById(id);
        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedUser);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    public void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("lastName", "Green");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }



}