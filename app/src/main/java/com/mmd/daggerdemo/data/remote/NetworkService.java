package com.mmd.daggerdemo.data.remote;

import android.content.Context;

import com.mmd.daggerdemo.data.qualifiers.NetworkQualifier;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkService {

    private Context context;
    private String apiKey;

    @Inject
    public NetworkService(@NetworkQualifier String apiKey) {
        // do the initialisation here
        this.context = context;
        this.apiKey = apiKey;
    }

    public String getDummyData() {
        return "NETWORK_DUMMY_DATA";
    }

    public String fetchData(){
        return "responce off request";
    }
}
