package com.example.chopechat.base;

import android.app.Application;
import com.example.chopechat.di.components.CoreComponent;
import com.example.chopechat.di.components.DaggerCoreComponent;

public class BaseApplication extends Application {

    public CoreComponent appComponent = DaggerCoreComponent.factory().create(this);

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
