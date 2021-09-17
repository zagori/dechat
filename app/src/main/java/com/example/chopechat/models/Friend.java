package com.example.chopechat.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "friends_table", primaryKeys = {"friendName"})
public class Friend {
    @NonNull
    private String friendName;
    private String lastMessage;
    private long timestamp;

    public Friend() {
    }

    public Friend(String friendName) {
        this.friendName = friendName;
    }

    public Friend(@NonNull String friendName, String lastMessage, long timestamp) {
        this.friendName = friendName;
        this.lastMessage = lastMessage;
        this.timestamp = timestamp;
    }

    @NonNull
    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(@NonNull String friendName) {
        this.friendName = friendName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
