package com.mmd.daggerdemo.data;


import android.app.Application;

import com.mmd.daggerdemo.data.component.ApplicationComponent;
import com.mmd.daggerdemo.data.component.DaggerApplicationComponent;
import com.mmd.daggerdemo.data.module.ApplicationModule;

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // ساخت ApplicationComponent
        applicationComponent = DaggerApplicationComponent.create();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
