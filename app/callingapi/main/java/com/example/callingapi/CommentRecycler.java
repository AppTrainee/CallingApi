package com.example.callingapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentRecycler extends AppCompatActivity {
    RecyclerView commentRecy;
    TextView postTitle;
    List<CommentModal> commentlist;
    CommentsAdaptor commentsAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_recycler);
        commentRecy=findViewById(R.id.commentsRecycleView);
        postTitle=findViewById(R.id.posttitle);
        Bundle intentData =getIntent().getExtras();

        String postId=intentData.getString("id");
        String titlee=intentData.getString("title");

        if (postId != null) {
            fetchComments(Integer.parseInt(postId));
        }
        if (titlee != null) {
            postTitle.setText(titlee);
        }
    }

    private void fetchComments(int postId) {

        RetrofitInstance.getInstance().apiInterface.getComments(postId).enqueue(new Callback<List<CommentModal>>() {
            @Override
            public void onResponse(Call<List<CommentModal>> call, Response<List<CommentModal>> response) {
                commentlist=response.body();

                LinearLayoutManager layout=new LinearLayoutManager(CommentRecycler.this,LinearLayoutManager.VERTICAL,false);
                commentRecy.setLayoutManager(layout);
                commentsAdaptor=new CommentsAdaptor(CommentRecycler.this,commentlist);
                commentRecy.setAdapter(commentsAdaptor);

                Toast.makeText(CommentRecycler.this, "onResponse:"+response.body().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CommentModal>> call, Throwable t) {
                Toast.makeText(CommentRecycler.this, "onFailure:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}