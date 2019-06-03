package com.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonRootName("user")
public class User implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("cpf")
    private String cpf;

    @SerializedName("email")
    private String email;

    @SerializedName("dateInsertion")
    private LocalDateTime dateInsertion;

    @SerializedName("phone")
    private String phone;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;
}
