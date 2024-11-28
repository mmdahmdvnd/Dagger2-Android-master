package com.mmd.daggerdemo.data.remote;

import android.content.Context;

import com.mmd.daggerdemo.data.module.User;
import com.mmd.daggerdemo.data.qualifiers.NetworkQualifier;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

@Singleton
public class NetworkService {

    private Context context;
    private final String apiKey;

    @Inject
    public NetworkService(@NetworkQualifier String apiKey) {
        // do the initialisation here
        this.context = context;
        this.apiKey = apiKey;
    }

    //todo
    // درخواست همراه با پارامتر id با مقدار userId به سرور
//    @GET("users/{id}")
//    public Single<User> getUser(@Path("id") int userId) {
//        return null;
//    }

    // درخواست بدون پارامتر به سرور
    @GET("getUser")
    public Single<User> getUser(int userId) {
        return null;
    }

}
