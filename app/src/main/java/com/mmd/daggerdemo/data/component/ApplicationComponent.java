package com.mmd.daggerdemo.data.component;

import android.content.Context;

import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.module.ApplicationModule;
import com.mmd.daggerdemo.data.qualifiers.AppContextQualifier;
import com.mmd.daggerdemo.data.remote.NetworkService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

void inject(MyApplication application);

@AppContextQualifier
Context getAppContext();

NetworkService getNetworkService();

}
