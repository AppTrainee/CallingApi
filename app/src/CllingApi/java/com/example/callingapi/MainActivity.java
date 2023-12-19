package com.example.callingapi;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    List<apiModal> albumlist;
    RecyclerAdaptor recyclerAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyler);

        LinearLayoutManager linearLayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(linearLayout);

//        recyclerAdaptor=new RecyclerAdaptor(MainActivity.this,albumlist);
//        recycler.setAdapter(recyclerAdaptor);

        RetrofitInstance.getInstance().apiInterface.getPost().enqueue(new Callback<List<apiModal>>() {
            @Override
            public void onResponse(Call<List<apiModal>> call, Response<List<apiModal>> response) {
                albumlist=response.body();
                recyclerAdaptor=new RecyclerAdaptor(MainActivity.this,albumlist);
                recycler.setAdapter(recyclerAdaptor);
                Log.d(TAG, "onResponse: " + response.body().size());
            }

            @Override
            public void onFailure(Call<List<apiModal>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }
}