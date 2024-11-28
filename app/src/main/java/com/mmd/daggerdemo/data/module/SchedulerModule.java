package com.mmd.daggerdemo.data.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Module
public class SchedulerModule {

    @Provides
    @Singleton
    Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    Scheduler provideMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
