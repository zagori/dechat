package com.example.dechat.di.modules;

import com.example.dechat.repositories.ChatRepository;
import com.example.dechat.source.local.ChatDao;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public ChatRepository provideChatRepository(ChatDao chatDao){
        return new ChatRepository(chatDao);
    }
}
