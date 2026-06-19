package com.example.docentesapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("login.php")
    Call<String> login(
            @Query("username") String username,
            @Query("password") String password
    );

}