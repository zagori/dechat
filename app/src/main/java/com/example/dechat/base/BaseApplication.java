package com.example.dechat.base;

import android.app.Application;
import com.example.dechat.di.components.CoreComponent;
import com.example.dechat.di.components.DaggerCoreComponent;

public class BaseApplication extends Application {

    public CoreComponent appComponent = DaggerCoreComponent.factory().create(this);

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
