package com.example.callingapi.DateApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DiscountInterface {
    @GET("discount-api/10021/2023-10-10")
        // Call<List<DisModal>> getData();
    Call<List<DisModal>> getData(@Query("dataId") int dataId);
}
