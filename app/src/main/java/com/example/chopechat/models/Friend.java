package com.example.chopechat.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "friends_table")
public class Friend {
    @PrimaryKey(autoGenerate = true) private int id;
    private String name;
    private String lastMessage;

    public Friend(){}

    public Friend(int id, String name, String lastMessage) {
        this.id = id;
        this.name = name;
        this.lastMessage = lastMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
