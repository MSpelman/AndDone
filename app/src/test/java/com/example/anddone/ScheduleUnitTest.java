package com.example.anddone;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Date;

/**
 * Unit test for the Schedule class
 * Created by MSpelman on 3/5/17.
 */
public class ScheduleUnitTest {
    Schedule schedule;
    Day day;

    @Before
    public void initialize() {
        schedule = new Schedule();
    }

    @Test
    public void addDayTest() throws Exception {
        day = new Day(new Date());
        Day[] dayArray = schedule.getDays();
        int numberOfDays = dayArray.length;
        schedule.addDay(day);
        assertEquals((numberOfDays + 1), schedule.getDays().length);
    }
}
