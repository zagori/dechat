package com.example.chopechat.di.modules;

import com.example.chopechat.source.local.ChatDao;
import com.example.chopechat.source.local.ChopeChatDB;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {

    @Provides
    @Singleton
    ChatDao provideChatDao(ChopeChatDB db){
        return db.chatDao;
    }
}
