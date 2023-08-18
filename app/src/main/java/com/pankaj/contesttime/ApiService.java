package com.pankaj.contesttime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("all")
    Call<List<Post>> getPost();

    @GET("code_chef")
    Call<List<Post>> getCodechef();

    @GET("codeforces")
    Call<List<Post>> getCodeForces();

    @GET("top_coder")
    Call<List<Post>> getTopCoder();

    @GET("hacker_rank")
    Call<List<Post>> getHackerRank();

}
