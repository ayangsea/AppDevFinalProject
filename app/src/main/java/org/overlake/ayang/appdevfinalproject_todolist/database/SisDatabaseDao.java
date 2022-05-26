package org.overlake.ayang.appdevfinalproject_todolist.database;

import androidx.lifecycle.LiveData;
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

    @Query("DELETE FROM Task")
    void nukeTasks();

    @Delete()
    void deleteTask(Task task);

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addCategory(Category category);

//    @Query("DELETE FROM Category WHERE name = category.name")
//    void deleteCategory(Category category);

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getCategories();

    @Query("DELETE FROM Category")
    void nukeCategories();

    //add a getcategoryid method
}
