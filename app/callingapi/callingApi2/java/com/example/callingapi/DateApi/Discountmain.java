package com.example.callingapi.DateApi;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.callingapi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Discountmain extends AppCompatActivity {
    DiscountInterface discountInterface;
    List<DisModal> dataList;
    RecyclerView discountrecycler;
    DisRecycAdaptor disRecycAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discountmain);
        discountrecycler = findViewById(R.id.Disrecycler);
        //  retrofitFun();
        retrofitFun("8390");
    }

    private void retrofitFun(String dataId) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://phplaravel-882494-3459554.cloudwaysapps.com/api/discount-api/").addConverterFactory(GsonConverterFactory.create()).build();
        discountInterface = retrofit.create(DiscountInterface.class);
        discountInterface.getData(Integer.parseInt(dataId)).enqueue(new Callback<List<DisModal>>() {
            @Override
            public void onResponse(Call<List<DisModal>> call, Response<List<DisModal>> response) {
                dataList = response.body();
                Toast.makeText(Discountmain.this, "onResponse:" + response.body().size(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onResponse:" + response.body().size());
//                LinearLayoutManager layout=new LinearLayoutManager(Discountmain.this,LinearLayoutManager.VERTICAL,false);
//                discountrecycler.setLayoutManager(layout);
//                disRecycAdaptor = new DisRecycAdaptor(Discountmain.this, dataList);
//                discountrecycler.setAdapter(disRecycAdaptor);

            }

            @Override
            public void onFailure(Call<List<DisModal>> call, Throwable t) {
                Toast.makeText(Discountmain.this, "onfailure:" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });


    }
}