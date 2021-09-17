package com.example.chopechat.viewmodels;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.chopechat.models.Chat;
import com.example.chopechat.models.Friend;
import com.example.chopechat.models.StateLiveData;
import com.example.chopechat.repositories.ChatRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ChatViewModel extends ViewModel {

    public StateLiveData<List<Friend>> friendsLiveData = new StateLiveData<>();
    private StateLiveData<List<Chat>> chatsLiveData = new StateLiveData<>();

    @Inject
    ChatRepository chatRepository;

    @Inject
    CompositeDisposable compositeDisposable;

    private void loadChats() {
        compositeDisposable.add(
                chatRepository.getChats()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> chatsLiveData.postLoading())
                        .subscribe(new Consumer<List<Chat>>() {
                            @Override
                            public void accept(List<Chat> chats) throws Throwable {
                                Log.d(this.getClass().getName(), "++> chats: " + chats.toString());
                            }
                        })
        );
    }

    private void addChats(Chat chat) {
        compositeDisposable.add(
                chatRepository.addChat(chat)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
        );
    }

    public void loadFriends() {
        compositeDisposable.add(
                chatRepository.getFriends()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> friendsLiveData.postLoading())
                        .subscribeWith(new DisposableObserver<List<Friend>>() {

                            @Override
                            public void onNext(@NonNull List<Friend> friends) {
                                friendsLiveData.postSuccess(friends);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                            }

                            @Override
                            public void onComplete() {

                            }
                        })
        );
    }

    private void addFriends() {
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

    public void init() {
        addFriends();
    }


    @Override
    protected void onCleared() {
        if (!compositeDisposable.isDisposed()) compositeDisposable.dispose();
        super.onCleared();
    }
}
