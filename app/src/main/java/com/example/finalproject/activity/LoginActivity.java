package com.example.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.finalproject.API.RetrofitClient;
import com.example.finalproject.R;
import com.example.finalproject.dto.UserLoginDTO;
import com.example.finalproject.model.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUser, txtPassword;
    private RelativeLayout pbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.login_txtUser);
        txtPassword = findViewById(R.id.login_txtPassword);
        pbLogin = findViewById(R.id.pbLogin);
    }

    public void access(View view){
        if(validateLogin()) {
            pbLogin.setVisibility(View.VISIBLE);
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
                .login(userLoginDTO);

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    pbLogin.setVisibility(View.INVISIBLE);
                    finish();
                    Toast.makeText(LoginActivity.this, "Acessado com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    pbLogin.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "Usuário não encontrado.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                pbLogin.setVisibility(View.INVISIBLE);
                Log.i("", t.getMessage(), t);
                Toast.makeText(LoginActivity.this, "Erro ao acessar, tente mais tarde.", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
