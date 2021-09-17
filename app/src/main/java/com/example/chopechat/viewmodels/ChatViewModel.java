package com.example.chopechat.viewmodels;

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
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ChatViewModel extends ViewModel {

    public StateLiveData<List<Friend>> friendsLiveData = new StateLiveData<>();
    public StateLiveData<List<Chat>> chatsLiveData = new StateLiveData<>();

    public Friend selectedFriend;// = new Friend();

    @Inject
    ChatRepository chatRepository;

    @Inject
    CompositeDisposable compositeDisposable;

    public void loadChats(String friendName) {
        compositeDisposable.add(
                chatRepository.getChatsWith(friendName)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> chatsLiveData.postLoading())
                        .subscribeWith(new DisposableObserver<List<Chat>>(){

                            @Override
                            public void onNext(@NonNull List<Chat> chats) {
                                chatsLiveData.postSuccess(chats);
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

    public void addChats(Chat chat) {
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
