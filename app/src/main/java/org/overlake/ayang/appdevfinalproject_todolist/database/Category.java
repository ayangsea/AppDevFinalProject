package org.overlake.ayang.appdevfinalproject_todolist.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {

    @PrimaryKey(autoGenerate = true)
    public int categoryID;

    @ColumnInfo
    public String name;

    public Category(String name) {
        this.name = name;
    }
}
