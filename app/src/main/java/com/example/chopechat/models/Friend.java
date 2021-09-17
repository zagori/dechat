package com.example.chopechat.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "friends_table", primaryKeys = {"friendName"})
public class Friend {
    @NonNull private String friendName;
    @Ignore private String lastMessage;

    public Friend() {
    }

    public Friend(String friendName) {
        this.friendName = friendName;
    }

    public Friend(String friendName, String lastMessage) {
        this.friendName = friendName;
        this.lastMessage = lastMessage;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
