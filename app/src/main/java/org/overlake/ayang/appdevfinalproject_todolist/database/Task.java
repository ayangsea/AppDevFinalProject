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

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

}
