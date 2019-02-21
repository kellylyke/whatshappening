package com.kellylyke.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import com.kellylyke.entity.User;
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
        dao = new UserDao();
    }


    @Test
    public void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(2, users.size());
    }


}