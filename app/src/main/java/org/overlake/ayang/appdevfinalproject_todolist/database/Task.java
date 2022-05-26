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

    public Task(String taskDescription, boolean urgent) {
        this.taskDescription = taskDescription;
        this.urgent = urgent;
    }

    public boolean isUrgent() {
        return urgent;
    }
}
