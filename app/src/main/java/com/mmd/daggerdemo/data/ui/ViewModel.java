package com.mmd.daggerdemo.data.ui;

import com.mmd.daggerdemo.data.Scope.AcitvityScope;
import com.mmd.daggerdemo.data.remote.NetworkService;

import javax.inject.Inject;

@AcitvityScope
public class ViewModel {

    private NetworkService networkService;

    @Inject
    public ViewModel(NetworkService networkService) {
        this.networkService = networkService;
    }

    public String getSomeData() {
        return networkService.getDummyData();
    }
}
