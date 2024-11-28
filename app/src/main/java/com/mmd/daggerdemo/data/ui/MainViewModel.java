package com.mmd.daggerdemo.data.ui;

import androidx.lifecycle.ViewModel;

import com.mmd.daggerdemo.data.Scope.ActivityScope;
import com.mmd.daggerdemo.data.module.User;
import com.mmd.daggerdemo.data.qualifiers.IoScheduler;
import com.mmd.daggerdemo.data.qualifiers.MainThreadScheduler;
import com.mmd.daggerdemo.data.remote.NetworkService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;

@ActivityScope
public class MainViewModel extends ViewModel {

    private NetworkService networkService;
    private final Scheduler ioScheduler;
    private final Scheduler mainThreadScheduler;

    @Inject
    public MainViewModel(
            NetworkService networkService,
            @IoScheduler Scheduler ioScheduler,
            @MainThreadScheduler Scheduler mainThreadScheduler
    ) {
        this.networkService = networkService;
        this.ioScheduler = ioScheduler;
        this.mainThreadScheduler = mainThreadScheduler;
    }

    public Single<User> getUser(int userId) {
        return networkService.getUser(userId)
                .subscribeOn(ioScheduler)
                .observeOn(mainThreadScheduler);
    }

}
