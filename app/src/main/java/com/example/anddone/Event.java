package com.example.anddone;

//import java.time.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Event
 * An Event object corresponds to an appointment; the user needs to do or be somewhere at
 * a specific time. It can have a list of Tasks that need to be completed before the Event
 * (e.g. prep for a meeting) or Tasks that will be done as part of the event (e.g. agenda items).
 * Created by MSpelman on 3/9/17.
 *
 * Note: An Event does not have a date associated with it!  Its date is currently derived from the
 * Day it is associated with.  This may be changed, or we may need to add a field that points
 * back to the associated Day record (right now there is just a pointer from the Day to the Event)
 */
public class Event implements IScheduleItem {
    private String name;  // Event title
    private String description;  // A short description of the Event
    private Date startTime;  // Replace type with ZonedDateTime?
    private int duration;  // Replace type with Duration? How long event lasts
    private String location;
    private int reminderTime;  // Amount of time before Event for reminder
    private Recurrence recurrance;
    private ArrayList<Task> beforeTasks;  // Tasks to complete before Event
    private ArrayList<Task> duringTasks;  // Tasks to be done during Event
    private ArrayList<User> sharedWith;  // Users the Task has been shared with
    private ArrayList<Event> childEvents;  // Child Events created by sharing this Event
    private Event parentEvent;  // Parent Event that was shared with this user

    /**
     * Constructor
     * We will likely need to overload this
     * @param name  The title of the Event
     * @param description  A short summary of the Event
     */
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        beforeTasks = new ArrayList<>();
        duringTasks = new ArrayList<>();
        sharedWith = new ArrayList<>();
    }

    public enum Recurrence {
        DAILY,
        WEEKLY,
        MONTHLY
    }

    /**
     * Adds a new Task to the list of before event tasks
     * @param newTask  The new Task to add to the list
     */
    public void addBeforeTask(Task newTask) {
        beforeTasks.add(newTask);
    }

    /**
     * Adds a new Task to the list of during event tasks
     * @param newTask  The new Task to add to the list
     */
    public void addDuringTask(Task newTask) {
        duringTasks.add(newTask);
    }

    /**
     * Shares the Event with another user
     * @param user  The user to share the Event with
     */
    public void shareWith(User user) {
        sharedWith.add(user);
        // Code to actually share Event goes here
    }

    /**
     * Retrieves the before Tasks associated with this Event
     * @return An array with the Tasks
     */
    public Task[] getBeforeTasks() {
        Task[] taskArray = new Task[beforeTasks.size()];
        beforeTasks.toArray(taskArray);
        return taskArray;
    }

    /**
     * Retrieves the during Tasks associated with this Event
     * @return An array with the Tasks
     */
    public Task[] getDuringTasks() {
        Task[] taskArray = new Task[duringTasks.size()];
        duringTasks.toArray(taskArray);
        return taskArray;
    }

    /**
     * Retrieves the users this Event has been shared with
     * @return An array with the Users
     */
    public User[] getSharedWith() {
        User[] userArray = new User[sharedWith.size()];
        sharedWith.toArray(userArray);
        return userArray;
    }
}
