package com.example.dechat.di.modules;

import android.content.Context;
import androidx.room.Room;
import com.example.dechat.source.local.DechatDB;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public DechatDB provideDatabase(Context context){
        return Room.databaseBuilder(context, DechatDB.class,"chope_chat_db")
                .fallbackToDestructiveMigration().build();
    }
}
