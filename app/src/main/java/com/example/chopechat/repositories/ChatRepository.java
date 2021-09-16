package com.example.chopechat.repositories;

import com.example.chopechat.models.Friend;
import com.example.chopechat.models.Status;
import com.example.chopechat.source.local.ChatDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;

public class ChatRepository {

    private ChatDao chatDao;

    @Inject public ChatRepository(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    Completable addFriends(List<Friend> friends){
        return chatDao.insertFriends(friends);
    }

    Flowable<Status<List<Friend>>> getFriends(){
        return chatDao.getAllFriends().map(new Function<List<Friend>, Status<List<Friend>>>() {
            @Override
            public Status<List<Friend>> apply(List<Friend> friends) throws Throwable {
                return new Status.Success<>(friends);
            }
        });
    }
}
