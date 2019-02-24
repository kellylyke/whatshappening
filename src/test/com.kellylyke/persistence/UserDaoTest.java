package com.kellylyke.persistence;


import com.kellylyke.entity.User;
import com.kellylyke.persistence.UserDao;
import java.util.List;
import static org.junit.Assert.*;
import com.kellylyke.test.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;

public class UserDaoTest {

    UserDao dao;

    /**
     * Sets up dao, recreates fresh database
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {

        dao = new UserDao();
        System.out.println("Before Each initEach() method called");
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Tests get all users success.
     */
    @Test
    public void getAllUsersSuccess() {
        dao = new UserDao();
        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());
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
        dao = new UserDao();
        User retrievedUser = dao.getById(3);
        Assert.assertEquals("Monica", retrievedUser.getFirstName());
        Assert.assertEquals("Geller", retrievedUser.getLastName());
        Assert.assertEquals("mgeller", retrievedUser.getUserName());
        assertEquals(10031, retrievedUser.getZipcode());
        Assert.assertEquals("mgeller@yahoo.com", retrievedUser.getEmail());
        Assert.assertEquals("ilovecooking", retrievedUser.getPassword());

    }

    /**
     * Verify successful insert of a user
     */
    @Test
    public void insertSuccess() {
        User newUser = new User("Joey", "Tribbiani", "joe", 90210, "drakeramorayl@daysofourlives.com", "pizza");
        int id = dao.insertUser(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        Assert.assertEquals("Joey", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of user
     */
    @Test
    public void deleteSuccess() {
        dao.delete(dao.getById(6));
        Assert.assertNull(dao.getById(6));
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