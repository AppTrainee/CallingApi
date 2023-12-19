package com.example.callingapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("posts")
    Call<List<apiModal>> getPost();

    @GET("comments")
    Call<List<CommentModal>>  getComments(@Query("postId") int postid);
}
