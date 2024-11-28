package com.mmd.daggerdemo.data.component;

import android.content.Context;

import com.mmd.daggerdemo.data.module.ApplicationModule;
import com.mmd.daggerdemo.data.module.NetworkModule;
import com.mmd.daggerdemo.data.module.RxModule;
import com.mmd.daggerdemo.data.qualifiers.AppContextQualifier;
import com.mmd.daggerdemo.data.qualifiers.IoScheduler;
import com.mmd.daggerdemo.data.qualifiers.MainThreadScheduler;
import com.mmd.daggerdemo.data.qualifiers.NetworkQualifier;
import com.mmd.daggerdemo.data.remote.NetworkService;
import com.mmd.daggerdemo.data.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.rxjava3.core.Scheduler;

@Singleton
@Component(modules = {ApplicationModule.class, RxModule.class})
public interface ApplicationComponent {
    @IoScheduler
    Scheduler ioScheduler();

    @MainThreadScheduler
    Scheduler mainThreadScheduler();

    ActivityComponent.Builder activityComponentBuilder();
}

