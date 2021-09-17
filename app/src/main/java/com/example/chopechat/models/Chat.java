package com.example.chopechat.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "chats_table")
public class Chat {
    @PrimaryKey(autoGenerate = true) private int id;
    private String message;
    private boolean isSent;
    private long timestamp;
    private String friendName;

    public Chat() {
    }

    public Chat(String message, boolean isSent, long timestamp, String friendName) {
        this.message = message;
        this.isSent = isSent;
        this.timestamp = timestamp;
        this.friendName = friendName;
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

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
