package com.example.anddone;

import java.util.Date;
import java.util.ArrayList;

/**
 * Day
 * A day object corresponds to a specific date in a user's schedule
 * Created by MSpelman on 3/4/17.
 */

public class Day {
    private Date date;
    private ArrayList<Event> events;
    private ArrayList<Task> tasks;

    public Day(Date date) {
        this.date = date;
        events = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public Date getDate(){
        return date;
    }

    public void addEvent(Event newEvent) {
        events.add(newEvent);
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
    }
}
