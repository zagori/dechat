package com.example.chopechat.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.chopechat.models.Chat;
import com.example.chopechat.models.Friend;
import com.example.chopechat.models.Response;
import com.example.chopechat.models.StateLiveData;
import com.example.chopechat.repositories.ChatRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ChatViewModel extends ViewModel {

    private StateLiveData<Response<List<Friend>>> friends;
    private MutableLiveData<Response<List<Chat>>> chats;

    @Inject
    ChatRepository chatRepository;

    @Inject
    CompositeDisposable compositeDisposable;


    void addFriends(){
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Jone"));
        friends.add(new Friend("Kent"));
        compositeDisposable.add(
                chatRepository.addFriends(friends)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
        );
    }


    public StateLiveData<Response<List<Friend>>> getFriends(){
        if (friends == null){
            friends = new StateLiveData<>();
            loadFriends();
        }

        return friends;
    }

    private void loadFriends(){
        compositeDisposable.add(
                chatRepository.getFriends()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> friends.postLoading())
                        .subscribe(new Consumer<List<Friend>>() {
                            @Override
                            public void accept(List<Friend> friends) throws Throwable {
                                Log.d(this.getClass().getName(), "++> friends: " + friends.toString());
                            }
                        })
                        //.subscribe(onNext ->{}, onError-> {})
        );
    }

    public void init(){
        addFriends();
    }



}
