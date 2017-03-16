package com.example.anddone;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Helper class for providing content for the To do fragment
 */
public class TodoContent {
    public List<IScheduleItem> scheduleItems = new ArrayList<>();

    public TodoContent() {
        // This code is for testing purposes only, needs to be removed
        User user = new User("id1", "Harry", "Jones");;
        Schedule schedule;
        Day today;
        Day tomorrow = null;
        schedule = createMockData(user);

        // Start of actual code
        today = schedule.getDays()[0];
        Event[] todaysEvents;
        Task[] todaysTasks;

        todaysTasks = today.getTasks();

        for (int i = 0; i < todaysTasks.length; i++) {
            scheduleItems.add(todaysTasks[i]);
        }
    }

    private Schedule createMockData(User user) {
        Schedule schedule = user.getSchedule();
        Day today = new Day(new Date());
        schedule.addDay(today);
        Event event = new Event("Group Meeting", "Meet with group");
        today.addEvent(event);
        Task task = new Task("Walk Dog", "Walk the dog");
        today.addTask(task);
        return schedule;
    }
}