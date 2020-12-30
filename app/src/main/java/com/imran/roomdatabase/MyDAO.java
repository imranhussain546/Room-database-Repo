package com.imran.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDAO
{

    @Insert
    public void adduser(User user);

    @Query("select * from user")
    public List<User> getuser();

    @Update
    public  void updateuser(User user);

    @Delete
    public  void deleteuser(User user);

}
