package com.example.astroworld.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connection_baseurl
{
    public static String BASEURL="http://192.168.43.205:8080/AstroWorld/";
    public Retrofit creater()
    {
        Gson gson=new GsonBuilder().setLenient().create();
        Retrofit r=new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        return r;
    }
}
