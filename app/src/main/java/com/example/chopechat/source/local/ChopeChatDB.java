package com.example.chopechat.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {},
        version = 1
)
public abstract class ChopeChatDB extends RoomDatabase {
    public ChatDao chatDao;
}
