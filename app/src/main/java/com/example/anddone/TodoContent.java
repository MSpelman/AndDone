package com.example.anddone;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

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
        Day tomorrow = null;
        schedule = createMockData(user);

        // Start of actual code
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
    }

    private Schedule createMockData(User user) {
        Schedule schedule = user.getSchedule();
        Day today = new Day(new Date());
        schedule.addDay(today);

        // Add Event
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 1);
        calendar.set(Calendar.MINUTE, 0);
        Event event = new Event("Group Meeting", "Meet with CS 470 group", calendar.getTime());
        today.addEvent(event);

        // Add Task
        calendar.set(Calendar.HOUR, 22);
        Task task = new Task("354 HW2", "354 HW 2 is due", calendar.getTime());
        today.addTask(task);
        return schedule;
    }
}