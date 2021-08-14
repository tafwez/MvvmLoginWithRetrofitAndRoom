package com.hassantafwez.loginmvvm.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hassantafwez.loginmvvm.Model.Datum;

import java.util.List;

@Dao
public interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Datum> cats);

    @Query("SELECT DISTINCT * FROM catimg")
    LiveData<List<Datum>>  getcats();

    @Query("DELETE FROM catimg")
    void deleteAll();
}
