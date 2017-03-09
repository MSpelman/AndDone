package com.example.anddone;

//import java.time.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Task
 * A Task object corresponds to a something that needs to be done, usually with a due date.
 * It can be associated with an Event or be on its own.
 * Created by MSpelman on 3/5/17.
 *
 * Note: A Task does not have a date associated with it!  Its date is currently derived from the
 * Day it is associated with.  This may be changed, or we may need to add a field that points
 * back to the associated Day record (right now there is just a pointer from the Day to the Task)
 */
public class Task implements IScheduleItem {
    private String name;  // Task title
    private String description;  // A short description of the Task
    private Date timeDue;  // Replace type with ZonedDateTime? The time on that date the task is due
    private Priority priority;
    private boolean completed;  // Marks the Task as completed
    private Recurrence recurrance;
    private int timeEstimate;  // Replace type with Duration? Estimate of how long Task will take
    private int timeSpent;  // Replace type with Duration? Time spent on Task (from Start Task timer)
    private ArrayList<User> sharedWith;  // Users the Task has been shared with
    private User owner;  // User responsible for Task's completion
    private ArrayList<Task> childTasks;  // Child tasks created by sharing this Task
    private Task parentTask;  // Parent Task that was shared with this user

    /**
     * Constructor
     * We will likely need to overload this
     * @param name  The title of the Task
     * @param description  A short summary of the Task
     */
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
        sharedWith = new ArrayList<>();
    }

    public enum Priority {
        HIGH,
        MEDIUM,
        LOW
    }

    public enum Recurrence {
        DAILY,
        WEEKLY,
        MONTHLY
    }

    /**
     * Marks the Task as completed
     */
    public void completeTask() {
        completed = true;
    }

    /**
     * Convenience method for determining if the Task is completed
     * @return true if the Task is complete, else false
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Shares the Task with another user
     * @param user  The user to share the Task with
     */
    public void shareWith(User user) {
        sharedWith.add(user);
        // Code to actually share Task goes here
    }

    /**
     * Retrieves the users this Task has been shared with
     * @return An array with the Users
     */
    public User[] getSharedWith() {
        User[] userArray = new User[sharedWith.size()];
        sharedWith.toArray(userArray);
        return userArray;
    }
}
