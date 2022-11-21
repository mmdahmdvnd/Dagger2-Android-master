package com.mmd.daggerdemo.data.module;

import android.content.Context;

import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.qualifiers.AppContextQualifier;
import com.mmd.daggerdemo.data.qualifiers.DatabaseQualifier;
import com.mmd.daggerdemo.data.qualifiers.NetworkQualifier;


import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

private MyApplication application;

public ApplicationModule(MyApplication application){

    this.application =application;
}


    @Provides
@AppContextQualifier
Context provideContext(){return application;}

    @Provides
@DatabaseQualifier
String provideDatabaseName(){ return "dbName";}

    @Provides
@NetworkQualifier
String provideNetworkKey(){ return "dbName";}

    @Provides
@DatabaseQualifier
Integer provideDataBaseVersion(){ return 1;}


}
