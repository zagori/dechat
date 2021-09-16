package com.example.chopechat.source.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.chopechat.models.Friend;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertFriends(List<Friend> friends);

    @Query("SELECT * FROM friends_table")
    Flowable<List<Friend>> getAllFriends();

    @Query("DELETE FROM friends_table")
    void deleteAll();
}
