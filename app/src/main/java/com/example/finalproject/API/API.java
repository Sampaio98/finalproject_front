package com.example.finalproject.API;

import com.example.finalproject.dto.UserInsertDTO;
import com.example.finalproject.dto.UserLoginDTO;
import com.example.finalproject.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {

    @POST("user/login")
    Call<User> login(@Body UserLoginDTO userLoginDTO);

    @GET("user/{id}")
    Call<User> findById(@Path("id") Long id);

    @POST("user")
    Call<Void> createUser(@Body UserInsertDTO userInsertDTO);
}
