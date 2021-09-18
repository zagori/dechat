package com.example.dechat.di.modules;

import com.example.dechat.source.local.ChatDao;
import com.example.dechat.source.local.DechatDB;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {

    @Provides
    @Singleton
    ChatDao provideChatDao(DechatDB db){
        return db.getChatDao();
    }
}
