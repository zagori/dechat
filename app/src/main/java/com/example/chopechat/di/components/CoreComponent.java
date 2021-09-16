package com.example.chopechat.di.components;

import android.app.Application;
import com.example.chopechat.di.modules.ContextModule;
import com.example.chopechat.di.modules.DaoModule;
import com.example.chopechat.di.modules.DatabaseModule;
import com.example.chopechat.di.modules.RepositoryModule;
import com.example.chopechat.repositories.ChatRepository;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(
        modules = {
                ContextModule.class,
                RepositoryModule.class,
                DatabaseModule.class,
                DaoModule.class
        }
)
@Singleton
public interface CoreComponent {

    @Component.Factory
    interface Factory{
        CoreComponent create(@BindsInstance Application application);
    }

    ChatRepository ChatRepository();

    // Inject more repositories that are to be injected in the viewModels in here ...
}
