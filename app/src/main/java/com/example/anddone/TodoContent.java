package com.example.anddone;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
//import android.content.Context;
//import android.content.res.Resources;


/**
 * Helper class for providing content for the To do fragment
 */
public class TodoContent {
    public List<IScheduleItem> scheduleItems = new ArrayList<>();

    public TodoContent() {
        // This code is for testing purposes only, needs to be removed
        User user = new User("id1", "Harry", "Jones");
        Schedule schedule;
        Day today;
        Day tomorrow;
        createMockData(user);
        schedule = user.getSchedule();

        // Start of actual code
        /* TODAY */
        today = schedule.getDays()[0];
        Event[] todaysEvents;
        Task[] todaysTasks;

        todaysTasks = today.getTasks();
        todaysEvents = today.getEvents();
        scheduleItems.add(new Task("Today", ""));

        for (int i = 0; i < todaysTasks.length; i++) {
            scheduleItems.add(todaysTasks[i]);
        }

        for (int i = 0; i < todaysEvents.length; i++) {
            scheduleItems.add(todaysEvents[i]);
        }

        /* TOMORROW */
        tomorrow = schedule.getDays()[1];
        Event[] tomorrowsEvents;
        Task[] tomorrowsTasks;

        tomorrowsTasks = tomorrow.getTasks();
        tomorrowsEvents = tomorrow.getEvents();
        scheduleItems.add(new Task("Tomorrow", ""));

        for (int i = 0; i < tomorrowsTasks.length; i++) {
            scheduleItems.add(tomorrowsTasks[i]);
        }

        for (int i = 0; i < tomorrowsEvents.length; i++) {
            scheduleItems.add(tomorrowsEvents[i]);
        }
    }

    private void createMockData(User user) {
        Schedule schedule = user.getSchedule();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        /* TODAY */
        Day today = new Day(new Date());

        // Add Task - 11:30 pm CS 354 HW4 - Blue
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.MINUTE, 30);
        Task task = new Task("CS 354 HW4", "354 HW 4 is due", calendar.getTime());
        today.addTask(task);

        // Add Task w/o time - Walk Dog - Completed - Black
        task = new Task("Walk Dog", "Walk dog around block");
        task.completeTask();
        today.addTask(task);

        // Add Event - 3:00 pm Group Meeting - Pink
        calendar.set(Calendar.HOUR, 3);
        calendar.set(Calendar.MINUTE, 0);
        Event event = new Event("Group Meeting", "Meet with CS 470 group", calendar.getTime());
        today.addEvent(event);

        schedule.addDay(today);

        /* TOMORROW */
        calendar.roll(Calendar.DATE, 1);
        Day tomorrow = new Day (calendar.getTime());

        // Add Task - 11:00 pm CS 367 HW3 - Completed - Black
        calendar.set(Calendar.HOUR, 11);
        task = new Task("CS 367 HW3", "367 HW3 is due", calendar.getTime());
        task.completeTask();
        tomorrow.addTask(task);

        // Add Task w/o time - Walk Dog - Blue
        task = new Task("Walk Dog", "Take dog to dog park");
        tomorrow.addTask(task);

        // Add Event - 5:00 pm Group Meeting - Pink
        calendar.set(Calendar.HOUR, 5);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.AM_PM, Calendar.PM);
        event = new Event("Group Meeting", "Meet with CS 506 group", calendar.getTime());
        tomorrow.addEvent(event);

        schedule.addDay(tomorrow);
    }
}