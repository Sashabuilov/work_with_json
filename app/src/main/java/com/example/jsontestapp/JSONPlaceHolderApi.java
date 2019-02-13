package com.example.jsontestapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JSONPlaceHolderApi {

    @Headers({"Content-Type: application/json; charset=utf-8"})
    @GET ("/api/test/user")
    Call<Response_User> getUser();


    @Headers({"Content-Type: application/json; charset=utf-8"})
    @POST("/api/test/login")
    Call<Response_token> sendLoginRequest(@Body Request_Login requestLogin);

    //Call<Response_User> getFirstName(@Path("firstName"));//@Body Request_Login requestLogin);
    //@POST("/api/test/user")
    // Call<Response_User> sendLoginRequest(@Body Request_Login requestLogin);
    // @Query("login") String login, @Query("pass") String pass);
}
