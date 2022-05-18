package org.overlake.ayang.appdevfinalproject_todolist.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SisDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addTask(Task task);

    @Delete()
    void deleteTask(Task task);

    @Query("SELECT taskDescription FROM Task")
    List<Task> getTasks();
}
