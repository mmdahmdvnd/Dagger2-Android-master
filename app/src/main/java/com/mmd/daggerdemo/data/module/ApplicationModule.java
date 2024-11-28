package com.mmd.daggerdemo.data.module;

import android.content.Context;

import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.qualifiers.AppContextQualifier;
import com.mmd.daggerdemo.data.qualifiers.DatabaseQualifier;
import com.mmd.daggerdemo.data.qualifiers.NetworkQualifier;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

private MyApplication application;

public ApplicationModule(MyApplication application){
    this.application = application;
}
    @Provides
    @Singleton
    @AppContextQualifier
    Context provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    @NetworkQualifier
    public String provideNetworkApiKey() {
        // مقدار کلید API یا مقدار مشابه که برای NetworkService نیاز است
        return "YOUR_API_KEY";
    }

}
