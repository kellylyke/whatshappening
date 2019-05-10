package com.kellylyke.persistence;

import java.util.List;

import static org.junit.Assert.*;

import com.kellylyke.entity.Role;
import com.kellylyke.entity.User;
import com.kellylyke.test.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Test class for the roles
 *
 *@author klyke
 */
public class RoleDaoTest {

    private GenericDao dao;

    /**
     * Sets up dao, creates fresh database
     *
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao(Role.class);


    }

    /**
     * Tests get all roles success.
     */
    @Test
    public void getAllRolesSuccess() {

        List<Role> roles = dao.getAll();
        assertTrue(roles.size() > 0);
        assertEquals(2, roles.size());
    }

    /**
     * Verify successful delete of role
     */
    @Test
    public void deleteRoleSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));

    }


}