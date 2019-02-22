package com.kellylyke.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import com.kellylyke.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao dao;
    /**
     * Sets up dao
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        //com.kellylyke.project.Database database = com.kellylyke.project.util.Database.getInstance();
       // database.runSQL("cleandb.sql");

        dao = new UserDao();


    }

    /**
     * Tests get all users success.
     */
    @Test
    public void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    public void getByIdSuccess() {
        dao = new UserDao();
        User retrievedUser = dao.getById(3);
        assertEquals("Monica", retrievedUser.getFirstName());
        assertEquals("Geller", retrievedUser.getLastName());
        assertEquals("mgeller", retrievedUser.getUserName());
        assertEquals(10031, retrievedUser.getZipcode());
        assertEquals("mgeller@yahoo.com", retrievedUser.getEmail());
        assertEquals("ilovecooking", retrievedUser.getPassword());

    }

    /**
     * Verify successful insert of a user
     */
    @Test
    public void insertSuccess() {
        dao = new UserDao();

        User newUser = new User("Joey", "Tribbiani", "joe", 90210, "drakeramorayl@daysofourlives.com", "pizza");
        int id = dao.insertUser(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Joey", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of user
     */
    @Test
    public void deleteSuccess() {

        dao = new UserDao(); ///fix this crap
        dao.delete(dao.getById(7));
        Assert.assertNull(dao.getById(7));
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    public void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "Green");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    public void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "g");
        assertEquals(4, users.size());
    }





}