package com.kellylyke.persistence;

import com.kellylyke.entity.User;
import java.util.List;
import static org.junit.Assert.*;
import com.kellylyke.test.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;


/**
 * Test class for the user dao
 *
 *@author klyke
 */
public class UserDaoTest {

    UserDao dao;

    /**
     * Sets up dao, creates fresh database
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    /**
     * Tests get all users success.
     */
    @Test
    public void getAllUsersSuccess() {

        List<User> users = dao.getAllUsers();
        Assert.assertEquals(5, users.size());
    }

    /**
     * Tests get all users success.
     */
    @Test
    public void userUpdateSuccess() {
        String newLastName =  "Geller-Bing";
        User userToUpdate = dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        Assert.assertEquals(newLastName, retrievedUser.getLastName());
    }

    /**
     * Verify successful retrieval of a user by id
     */
    @Test
    public void getByIdSuccess() {

        User retrievedUser = dao.getById(4);
        Assert.assertEquals("Ross", retrievedUser.getFirstName());
        Assert.assertEquals("Geller", retrievedUser.getLastName());
        Assert.assertEquals("drgeller", retrievedUser.getUserName());
        assertEquals(10032, retrievedUser.getZipcode());
        Assert.assertEquals("rgeller@phd.edu", retrievedUser.getEmail());
        Assert.assertEquals("dinosrock", retrievedUser.getPassword());

    }

    /**
     * Verify successful insert of a user
     */
    @Test
    public void insertSuccess() {
        User newUser = new User("Joey", "Tribbiani", "joe", 90210, "drakeramoray@daysofourlives.com", "pizza");
        int id = dao.insertUser(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        Assert.assertEquals("Joey", insertedUser.getFirstName());
        Assert.assertEquals("Tribbiani", insertedUser.getLastName());
        Assert.assertEquals("joe", insertedUser.getUserName());
        Assert.assertEquals(90210, insertedUser.getZipcode());
        Assert.assertEquals("drakeramoray@daysofourlives.com", insertedUser.getEmail());
        Assert.assertEquals("pizza", insertedUser.getPassword());


    }

    /**
     * Verify successful delete of user
     */
    @Test
    public void deleteSuccess() {
        dao.delete(dao.getById(5));
        Assert.assertNull(dao.getById(5));
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    public void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("lastName", "Green");
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(1, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    public void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "g");
        Assert.assertEquals(4, users.size());
    }


}