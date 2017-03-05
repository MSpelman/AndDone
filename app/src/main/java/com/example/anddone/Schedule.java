package com.example.anddone;

import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Schedule
 * A schedule object corresponds to the schedule for a specific user
 * Created by MSpelman on 3/4/17.
 */

public class Schedule {
    private User user;
    private HashMap<Date, Day> days;

    public Schedule(User user) {
        this.user = user;
        days = new HashMap<>();
    }

    public void addDay(Day newDay) {
        Date key;
        key = newDay.getDate();
        days.put(key, newDay);
    }
}
