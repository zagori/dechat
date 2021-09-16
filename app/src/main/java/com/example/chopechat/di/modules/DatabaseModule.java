package com.example.chopechat.di.modules;

import android.content.Context;
import androidx.room.Room;
import com.example.chopechat.source.local.ChopeChatDB;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public ChopeChatDB provideDatabase(Context context){
        return Room.databaseBuilder(context, ChopeChatDB.class,"chope_chat_db")
                .fallbackToDestructiveMigration().build();
    }
}
