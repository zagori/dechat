package com.example.chopechat.repositories;

import com.example.chopechat.models.Chat;
import com.example.chopechat.models.Friend;
import com.example.chopechat.source.local.ChatDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public class ChatRepository {

    private final ChatDao chatDao;

    @Inject public ChatRepository(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    public Completable addFriends(List<Friend> friends){
        return chatDao.deleteAllFriends().andThen(chatDao.insertFriends(friends));
    }

    public Flowable<List<Friend>> getFriends(){
        return chatDao.getAllFriends();
    }

    public Completable addChat(Chat chat){
        return chatDao.insertChat(chat);
    }

    public Flowable<List<Chat>> getChats(){
        return chatDao.getAllChats();
    }
}
