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

    /**
     * Constructor
     * @param user  The user the schedule belongs to
     */
    public Schedule(User user) {
        this.user = user;
        days = new HashMap<>();
    }

    /**
     * Adds a Day to the Schedule
     * @param newDay  The Day that is being added to the Schedule
     */
    public void addDay(Day newDay) {
        Date key;
        key = newDay.getDate();
        days.put(key, newDay);
    }

    /**
     * Retrieves the Days associated with this Schedule
     * @return An array with the Days
     */
    public Day[] getDays() {
        Day[] dayArray = new Day[days.size()];
        days.values().toArray(dayArray);
        return dayArray;
    }
}
