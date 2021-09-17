package com.example.chopechat.repositories;

import com.example.chopechat.models.Chat;
import com.example.chopechat.models.Friend;
import com.example.chopechat.source.local.ChatDao;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class ChatRepository {

    private final ChatDao chatDao;

    @Inject public ChatRepository(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    /**
     * This will store list of friends
     * */
    public Completable addFriends(List<Friend> friends){
        return chatDao.insertFriends(friends);
    }

    /**
     * This will return the list of friends with latest chat for each
     * */
    public Observable<List<Friend>> getFriends(){
        return chatDao.getAllFriends();
    }


    /**
    * This will update both tables, friends and chats
    * */
    public Completable addChat(Chat chat){
        return Completable.mergeArray(
                chatDao.insertChat(chat).andThen(chatDao.insertChat(new Chat(chat.getMessage(), false,System.nanoTime(), chat.getFriendName()))),
                chatDao.updateFriends(new Friend(chat.getFriendName(), chat.getMessage(), chat.getTimestamp()))
        );
    }

    /**
     * This will load the list of chats with a specific friend
     * */
    public Observable<List<Chat>> getChatsWith(String friendName){
        return chatDao.getChatsWith(friendName);
    }
}
