package com.mmd.daggerdemo.data.module;

import android.content.Context;
import com.mmd.daggerdemo.data.qualifiers.ActivityContextQualifier;
import com.mmd.daggerdemo.data.ui.MainActivity;


import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    MainActivity activity;


    public ActivityModule(MainActivity activity){
        this.activity = activity;
    }

    @ActivityContextQualifier
    @Provides
    public Context provideActivityContext(){return activity;}
}
