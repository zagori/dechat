package com.example.chopechat.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.chopechat.models.Friend;

@Database(
        entities = {Friend.class},
        version = 1, exportSchema = false
)
public abstract class ChopeChatDB extends RoomDatabase {
    public abstract ChatDao getChatDao();
}
