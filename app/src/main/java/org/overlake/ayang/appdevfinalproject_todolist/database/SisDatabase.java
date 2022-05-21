package org.overlake.ayang.appdevfinalproject_todolist.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class SisDatabase extends RoomDatabase {
    public abstract SisDatabaseDao getDao();
}
