package com.example.finalproject.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserLoginDTO implements Serializable {

    @SerializedName("username")
    public String username;

    @SerializedName("password")
    public String password;


    public UserLoginDTO() {}


}
