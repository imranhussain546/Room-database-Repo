package com.imran.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
public abstract class MyDatabase extends RoomDatabase
{
public abstract MyDAO myDAO();
}
