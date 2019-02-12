package com.example.jsontestapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @Headers({"Content-Type: application/json; charset=utf-8"})
    @POST("/api/test/login")
    Call<Response_token> sendLoginRequest(@Body RequestLogin requestLogin);//@Query("login") String login, @Query("pass") String pass);

}
