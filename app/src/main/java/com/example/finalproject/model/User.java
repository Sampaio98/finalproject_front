package com.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

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

//    @SerializedName("dateInsertion")
//    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
//    private LocalDateTime dateInsertion;

    @SerializedName("phone")
    private String phone;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public User(){}

    public User(String name, String cpf, String email, String phone, String username, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public LocalDateTime getDateInsertion() {
//        return dateInsertion;
//    }
//
//    public void setDateInsertion(LocalDateTime dateInsertion) {
//        this.dateInsertion = dateInsertion;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
