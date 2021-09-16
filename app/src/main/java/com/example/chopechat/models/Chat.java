package com.example.chopechat.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "chats_table")
public class Chat {
    @PrimaryKey(autoGenerate = true) private int id;
    private String message;
    private boolean isSent;
    private long timestamp;
    private int friendId;

    public Chat() {
    }

    public Chat(int id, String message, boolean isSent, long timestamp, int friendId) {
        this.id = id;
        this.message = message;
        this.isSent = isSent;
        this.timestamp = timestamp;
        this.friendId = friendId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }
}
