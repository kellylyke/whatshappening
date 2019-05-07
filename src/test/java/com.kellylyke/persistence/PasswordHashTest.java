package com.kellylyke.persistence;


import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class PasswordHashTest {

    @Test
    public void testHashPasswordSuccess() {
        String password = "cool";
        String hashedPassword = PasswordHash.sha256(password);
        assertEquals("c34045c1a1db8d1b3fca8a692198466952daae07eaf6104b4c87ed3b55b6af1b", hashedPassword);
    }

}
