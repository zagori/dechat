package com.example.chopechat.di.modules;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@Module
public class CompositeDisposableModule {

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }
}
