package org.overlake.ayang.appdevfinalproject_todolist.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey
    public int taskID;
    public String taskDescription;

    public Task(int taskID, String taskDescription) {
        this.taskID = taskID;
        this.taskDescription = taskDescription;
    }

}
