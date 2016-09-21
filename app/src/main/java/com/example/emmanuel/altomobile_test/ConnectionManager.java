package com.example.emmanuel.altomobile_test;

import android.util.Log;

import com.example.emmanuel.altomobile_test.animal_utils.AnimalAdapter;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ConnectionManager {
    //Singleton Pattern to ensure only one connection is established
    private static ConnectionManager connectionManager = null;
    private OkHttpClient client;

    private ConnectionManager(){
        client = new OkHttpClient();
    }

    public static ConnectionManager GetInstance(){
        if (connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    //Get json from url in String
    public String GetResponse(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

}
