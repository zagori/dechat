package com.example.chopechat.source.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.chopechat.models.Chat;
import com.example.chopechat.models.Friend;
import java.util.List;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertFriends(List<Friend> friends);

    @Query("SELECT * FROM friends_table")
    Observable<List<Friend>> getAllFriends();

    @Query("DELETE FROM friends_table")
    Completable deleteAllFriends();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertChat(Chat... chat);

    @Query("SELECT * FROM chats_table WHERE friendName == :friendName")
    Observable<List<Chat>> getChatsWith(String friendName);

    @Query("DELETE FROM chats_table")
    Completable deleteAllChats();
}
