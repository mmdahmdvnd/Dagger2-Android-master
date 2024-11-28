package com.mmd.daggerdemo.data.remote;

import com.mmd.daggerdemo.data.module.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("Test.php/{id}")
    Call<User> getUser(@Path("id") int userId);
}
