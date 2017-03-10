package com.example.anddone;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Unit test for the Task class
 * Created by MSpelman on 3/7/17.
 */
public class TaskUnitTest {
    Task task;
    User user;

    @Before
    public void initialize() {
        task = new Task("Walk Dog", "Walk the dog around the block");
        user = new User("id1", "John", "Doe");
    }


    @Test
    public void completeTaskTest() throws Exception {
        assertEquals(false, task.isCompleted());
        task.completeTask();
        assertEquals(true, task.isCompleted());
    }

    @Test
    public void shareWithTest() throws Exception {
        User[] userArray = task.getSharedWith();
        int numberOfUsers = userArray.length;
        task.shareWith(user);
        assertEquals((numberOfUsers + 1), task.getSharedWith().length);
    }
}
