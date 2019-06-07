package com.example.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.API.RetrofitClient;
import com.example.finalproject.R;
import com.example.finalproject.dto.UserLoginDTO;
import com.example.finalproject.model.User;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUser, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser = findViewById(R.id.login_txtUser);
        txtPassword = findViewById(R.id.login_txtPassword);
    }

    public void access(View view){
        if(validateLogin()) {
            login();
        }
    }

    public void goToRegister(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private boolean validateLogin() {
        boolean aux = true;
        String user = txtUser.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        if (user.isEmpty()) {
            txtUser.setError("Informe o usuário");
            txtUser.requestFocus();
            aux = false;
        }

        if (password.isEmpty()) {
            txtPassword.setError("Informe a senha");
            txtPassword.requestFocus();
            aux = false;
        }

        return aux;
    }

    private UserLoginDTO getUserLoginDTO(){
        UserLoginDTO userLoginDTO = new UserLoginDTO();

        userLoginDTO.username = txtUser.getText().toString();
        userLoginDTO.password = txtPassword.getText().toString();

        return userLoginDTO;
    }

    private void login() {
        UserLoginDTO userLoginDTO = getUserLoginDTO();

        Call<User> call = RetrofitClient
                .getInstance()
                .getApi()
                .findById(1L);

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    Toast.makeText(LoginActivity.this, "DEU BOM CARALHO", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "AIIII", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
