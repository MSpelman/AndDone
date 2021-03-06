package com.example.anddone;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Unit test for the Event class
 * Created by MSpelman on 3/9/17.
 */

public class EventUnitTest {
    Event event;
    Task[] tasks;
    User user;

    @Before
    public void initialize() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 1);
        calendar.set(Calendar.MINUTE, 0);
        event = new Event("Vet Appointment", "Heart worm check and rabies vaccination", calendar.getTime());
        tasks = new Task[2];
        tasks[0] = new Task("Walk dog", "Take dog for walk");
        tasks[1] = new Task("Stool sample", "Get stool sample for vet");
        user = new User("id2", "Jane", "Smith");
    }

    @Test
    public void addBeforeTaskTest() throws Exception {
        Task[] taskArray = event.getBeforeTasks();
        int numberOfTasks = taskArray.length;
        event.addBeforeTask(tasks[0]);
        assertEquals((numberOfTasks + 1), event.getBeforeTasks().length);
    }

    @Test
    public void addDuringTaskTest() throws Exception {
        Task[] taskArray = event.getDuringTasks();
        int numberOfTasks = taskArray.length;
        event.addDuringTask(tasks[1]);
        assertEquals((numberOfTasks + 1), event.getDuringTasks().length);
    }

    @Test
    public void shareWithTest() throws Exception {
        User[] userArray = event.getSharedWith();
        int numberOfUsers = userArray.length;
        event.shareWith(user);
        assertEquals((numberOfUsers + 1), event.getSharedWith().length);
    }

    @Test
    public void getTimeTest() throws Exception {
        assertEquals("1:00 PM", event.getTime());
    }
}
