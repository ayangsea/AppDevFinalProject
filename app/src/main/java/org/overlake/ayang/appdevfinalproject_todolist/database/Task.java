package org.overlake.ayang.appdevfinalproject_todolist.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    public int taskID;

    @ColumnInfo
    public String taskDescription;
    public boolean urgent;
    public int category;
    public boolean done;

    public Task(String taskDescription, boolean urgent, int category, boolean done) {
        this.taskDescription = taskDescription;
        this.urgent = urgent;
        this.category = category;
        this.done = done;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isDone() {
        return done;
    }

    public void taskDone() {
        done = true;
    }

    public void taskNotDone() {
        done = false;
    }
}
