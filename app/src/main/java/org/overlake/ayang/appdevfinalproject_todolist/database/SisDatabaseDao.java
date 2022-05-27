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

    @Query("DELETE FROM Task WHERE category = :categoryID")
    void nukeTasks(int categoryID);

    @Delete()
    void deleteTask(Task task);

    @Query("SELECT * FROM Task WHERE category = :categoryID")
    LiveData<List<Task>> getTasks(int categoryID);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addCategory(Category category);

    @Delete()
    void deleteCategory(Category category);

    @Query("SELECT categoryID FROM CATEGORY WHERE name = :name")
    int getCategoryID(String name);

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> getCategories();

    @Query("DELETE FROM Category")
    void nukeCategories();

    //add a getcategoryid method
}
