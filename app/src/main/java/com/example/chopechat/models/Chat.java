package com.example.chopechat.models;

public class Chat {
    private int id;
    private String message;
    private boolean isSent;
    private long timestamp;
    private Friend friend;

    public Chat(int id, String message, boolean isSent, long timestamp, Friend friend) {
        this.id = id;
        this.message = message;
        this.isSent = isSent;
        this.timestamp = timestamp;
        this.friend = friend;
    }

    public Chat() { }

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

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }
}
