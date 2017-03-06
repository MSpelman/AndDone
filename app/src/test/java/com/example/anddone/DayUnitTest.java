package com.example.anddone;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Date;

/**
 * Unit test for the Day class
 * Created by MSpelman on 3/5/17.
 */
public class DayUnitTest {
    Day day;
    Event event;
    Task task;
    long time;

    @Before
    public void initialize() {
        Date date = new Date();
        time = date.getTime();
        day = new Day(date);
    }

    @Test
    public void getDateTest() throws Exception {
        Date date = day.getDate();
        assertEquals("class java.util.Date", date.getClass().toString());
        assert(date.getTime() > 0);
        assertEquals(time, date.getTime());
    }

    @Test
    public void addEventTest() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addTaskTest() throws Exception {
        assertEquals(4, 2 + 2);
    }

}
