package com.example.anddone;

import android.graphics.Bitmap;
import java.util.ArrayList;

/**
 * User
 * A User object corresponds to a specific user
 * It is needed for the proposed sharing functionality
 * Created by MSpelman on 3/9/17.
 */
public class User {
    private String id;  // User's Google id
    private String firstName;
    private String lastName;
    private Bitmap photo;  // Thumbnail photo of user to aid in Contact selection
    private Schedule schedule;
    private ArrayList<User> contacts;

    /**
     * Constructor
     * @param id  The User's id from Google
     * @param firstName  The User's first name
     * @param lastName  The User's last name
     */
    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        schedule = new Schedule();
        contacts = new ArrayList<>();
    }

    /**
     * Retrieves the User's schedule
     * @return  the Schedule object associated with this user
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Adds a User to contacts
     * @param newContact  The User being added to the contacts list
     */
    public void addContact(User newContact) {
        contacts.add(newContact);
    }

    /**
     * Retrieves this User's contacts
     * @return An array with the contacts' User objects
     */
    public User[] getContacts() {
        User[] userArray = new User[contacts.size()];
        contacts.toArray(userArray);
        return userArray;
    }
}
