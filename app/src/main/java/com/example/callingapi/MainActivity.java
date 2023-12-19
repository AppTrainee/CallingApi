package com.example.callingapi;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    List<apiModal> albumlist;
    RecyclerAdaptor recyclerAdaptor;
    TextView responsetext;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyler);
        responsetext = findViewById(R.id.responsetext);
        LinearLayoutManager linearLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(linearLayout);
        getpost();
    }
    private void getpost() {
        Map<String,String> parameters=new HashMap<>();  //declaring the map
        parameters.put("userId","6");
        parameters.put("_sort","id");
        parameters.put("_order","desc");
    //    RetrofitInstance.getInstance().apiInterface.getPost(new Integer[] {1,4}, "id", "desc").enqueue(new Callback<List<apiModal>>() {   //2nd way
        RetrofitInstance.getInstance().apiInterface.getPost(parameters).enqueue(new Callback<List<apiModal>>() {
            @Override
            public void onResponse(Call<List<apiModal>> call, Response<List<apiModal>> response) {
                albumlist = response.body();
                recyclerAdaptor = new RecyclerAdaptor(MainActivity.this, albumlist);
                recycler.setAdapter(recyclerAdaptor);
                Log.d(TAG, "onResponse:post " + response.body().size());
            }
            @Override
            public void onFailure(Call<List<apiModal>> call, Throwable t) {
                Log.e(TAG, "onFailure:post " + t.getMessage());
            }
        });
    }
}