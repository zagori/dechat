package com.example.dechat.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dechat.models.Chat;
import com.example.dechat.models.Friend;

@Database(
        entities = {Friend.class, Chat.class},
        version = 1, exportSchema = false
)
public abstract class ChopeChatDB extends RoomDatabase {
    public abstract ChatDao getChatDao();
}
