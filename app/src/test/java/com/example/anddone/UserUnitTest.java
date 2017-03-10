package com.example.anddone;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Unit test for the User class
 * Created by MSpelman on 3/9/17.
 */
public class UserUnitTest {
    User user;
    User contact;

    @Before
    public void initialize() {
        user = new User("id3", "Harry", "Jones");
        contact = new User("id4", "Samantha", "Jacobs");
    }

    @Test
    public void getScheduleTest() throws Exception {
        assertEquals("class com.example.anddone.Schedule", user.getSchedule().getClass().toString());
    }

    @Test
    public void addContactsTest() throws Exception {
        User[] contactArray = user.getContacts();
        int numberOfContacts = contactArray.length;
        user.addContact(contact);
        assertEquals((numberOfContacts + 1), user.getContacts().length);
    }
}
