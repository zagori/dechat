package com.example.chopechat.di.modules;

import com.example.chopechat.repositories.ChatRepository;
import com.example.chopechat.source.local.ChatDao;
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
