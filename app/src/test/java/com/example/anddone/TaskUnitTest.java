package com.example.anddone;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Unit test for the Task class
 * Created by MSpelman on 3/7/17.
 */
public class TaskUnitTest {
    Task task;
    User user;

    @Before
    public void initialize() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 1);
        calendar.set(Calendar.MINUTE, 0);
        task = new Task("Walk Dog", "Walk the dog around the block", calendar.getTime());
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

    @Test
    public void getTimeTest() throws Exception {
        assertEquals("1:00 PM", task.getTime());
    }
}
