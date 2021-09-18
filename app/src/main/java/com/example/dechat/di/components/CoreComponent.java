package com.example.dechat.di.components;

import android.app.Application;
import com.example.dechat.di.modules.ContextModule;
import com.example.dechat.di.modules.DaoModule;
import com.example.dechat.di.modules.DatabaseModule;
import com.example.dechat.di.modules.RepositoryModule;
import com.example.dechat.repositories.ChatRepository;

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
