package com.example.anddone;

import java.util.Date;
import java.util.ArrayList;

/**
 * Day
 * A day object corresponds to a specific date in a user's schedule
 * Created by MSpelman on 3/4/17.
 */
public class Day {
    private Date date;  // The date associated with the Day object
    private ArrayList<Event> events;  // List of Event objects that occur on that date
    private ArrayList<Task> tasks;  // List of Task objects that occur on that date

    /**
     * Constructor
     * @param date  The date the Day record is associated with
     */
    public Day(Date date) {
        this.date = date;
        events = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    /**
     * Accessor method that returns the date associated with the Day object
     * @return date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Adds an Event to the Day
     * @param newEvent  The Event that will occur on this Day
     */
    public void addEvent(Event newEvent) {
        events.add(newEvent);
    }

    /**
     * Adds a Task to the Day
     * @param newTask  The Task that will occur on this Day
     */
    public void addTask(Task newTask) {
        tasks.add(newTask);
    }

    /**
     * Retrieves the Tasks associated with this Day
     * @return An array with the Tasks
     */
    public Task[] getTasks() {
        Task[] taskArray = new Task[tasks.size()];
        tasks.toArray(taskArray);
        return taskArray;
    }
}
