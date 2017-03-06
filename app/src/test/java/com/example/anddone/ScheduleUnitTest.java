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
    User user;
    Schedule schedule;
    Day day;

    @Before
    public void initialize() {
        user = new User();
        schedule = new Schedule(user);
        day = new Day(new Date());
    }

    @Test
    public void addDayTest() throws Exception {
        assertEquals(4, 2 + 2);
    }
}
