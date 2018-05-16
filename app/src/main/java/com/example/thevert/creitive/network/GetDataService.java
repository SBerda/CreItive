package com.example.thevert.creitive.network;

import com.example.thevert.creitive.activity.ArticleListActivity;
import com.example.thevert.creitive.model.Article;
import com.example.thevert.creitive.model.BlogList;
import com.example.thevert.creitive.model.LoginCredentials;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface GetDataService {

    @POST("/login")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    Call<ResponseBody> loginWithCredentials(@Body LoginCredentials data);

    @GET("/blogs")
    Call<List<BlogList>> getBlogs(
            @Header("Accept") String acc,
            @Header("X-Authorize") String token);

    @GET("/blogs/{blogId}")
    Call<Article> getArticle(@Header("X-Authorize") String token,
                             @Header("Accept") String acc,
                             @Path("blogId") int blogId);


}


