package com.example.finalproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.finalproject.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void access(View view){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void goToRegister(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
