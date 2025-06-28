package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserAssertionsTest {

    @Test
    public void testUserAssertions() {
        String username = "admin";
        String expectedUsername = "admin";
        String nullValue = null;

        System.out.println("Starting UserAssertions test...");

        // Assert equality
        assertEquals("Username should match", expectedUsername, username);
        System.out.println("Username matches expected value");

        // Assert boolean true
        assertTrue("Username length should be greater than 3", username.length() > 3);
        System.out.println("Username length check passed");

        // Assert boolean false
        assertFalse("Username should not be empty", username.isEmpty());
        System.out.println("Username is not empty");

        // Assert null
        assertNull("Value should be null", nullValue);
        System.out.println("Null value check passed");

        // Assert not null
        assertNotNull("Username should not be null", username);
        System.out.println("Username is not null");

        System.out.println("All assertions passed successfully.");
    }
}
