package com.example.dechat.source.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.dechat.models.Chat;
import com.example.dechat.models.Friend;
import java.util.List;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertFriends(List<Friend> friends);

    @Update
    Completable updateFriends(Friend... friends);

    @Query("SELECT * FROM friends_table ORDER BY timestamp DESC")
    Observable<List<Friend>> getAllFriends();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertChat(Chat... chat);

    @Query("SELECT * FROM chats_table WHERE friendName == :friendName")
    Observable<List<Chat>> getChatsWith(String friendName);
}
