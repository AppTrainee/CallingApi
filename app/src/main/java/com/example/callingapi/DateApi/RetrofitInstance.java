package com.example.callingapi.DateApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
 public static    RetrofitInstance instance;
    DiscountInterface discountInterface;
    public String api = "https://phplaravel-882494-3459554.cloudwaysapps.com/";

    public RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).build();
        discountInterface=  retrofit.create(DiscountInterface.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }

}
