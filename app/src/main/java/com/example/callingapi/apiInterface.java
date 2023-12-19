package com.example.callingapi;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;

public interface apiInterface {
//    @GET("posts")
//    Call<List<apiModal>> getPost();

    /*for multiple quries
    //ist way
    @GET("posts")
    Call<List<apiModal>> getPost(@Query("userId") int userId,
                                 @Query("_sort") String sortby,
                                 @Query("_order") String order
                                 );   */

    /*if we want to see post of some specific multiple user Ids , we declare userid as an array
    //2nd way

    @GET("posts")
    Call<List<apiModal>> getPost(@Query("userId") Integer[] userId,
                                 @Query("_sort") String sortby,
                                 @Query("_order") String order
    );
*/
    /*if we wnt specify parameter name and parameter value in the mainActivity in form of a Map(Key-value  pair) */
    // 3rd way
    @GET("posts")
    Call<List<apiModal>> getPost(@QueryMap Map<String ,String> para);


//    @GET("comments")
//    Call<List<CommentModal>>  getComments(@Query("postId") int postid);

    @POST("posts")
           Call<apiModal> createPost(@Body apiModal apiPost);
    @GET("posts/{postId}/comments")
    Call<List<CommentModal>> getComments(@Path("id") int postId);
}
