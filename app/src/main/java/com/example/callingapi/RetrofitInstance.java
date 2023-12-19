package com.example.callingapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
 public static    RetrofitInstance instance;
    com.example.callingapi.apiInterface apiInterface;
    public String api = "https://jsonplaceholder.typicode.com/";

    public RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).build();
      apiInterface=  retrofit.create(com.example.callingapi.apiInterface.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }

}
