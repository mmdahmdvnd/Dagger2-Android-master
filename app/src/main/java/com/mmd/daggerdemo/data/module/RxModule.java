package com.mmd.daggerdemo.data.module;

import com.mmd.daggerdemo.data.Scope.ActivityScope;
import com.mmd.daggerdemo.data.qualifiers.IoScheduler;
import com.mmd.daggerdemo.data.qualifiers.MainThreadScheduler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Module
public class RxModule {

    @Provides
    @ActivityScope
    @MainThreadScheduler
    public Scheduler provideMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @ActivityScope
    @IoScheduler
    public Scheduler provideIoScheduler() {
        return Schedulers.io();
    }
}
