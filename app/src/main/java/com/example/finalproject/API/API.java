package com.example.finalproject.API;

import com.example.finalproject.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("/users/create")
    Call<User> registerUser(@Body User user);
}
