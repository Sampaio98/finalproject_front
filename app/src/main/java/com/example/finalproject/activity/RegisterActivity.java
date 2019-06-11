package com.example.finalproject.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.finalproject.API.RetrofitClient;
import com.example.finalproject.R;
import com.example.finalproject.dto.ProfessionalInsertDTO;
import com.example.finalproject.dto.UserInsertDTO;
import com.example.finalproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText txtName, txtEmail, txtCpf, txtPhone, txtUser, txtPassword;
    private RelativeLayout pbRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = findViewById(R.id.register_txtName);
        txtEmail = findViewById(R.id.register_txtEmail);
        txtCpf = findViewById(R.id.register_txtCpf);
        txtPhone = findViewById(R.id.register_txtPhone);
        txtUser = findViewById(R.id.register_txtUsername);
        txtPassword = findViewById(R.id.register_txtPassword);
        pbRegister = findViewById(R.id.pbRegister);
    }

    public void register(View view) {
        if (validateRegister()) {
            pbRegister.setVisibility(View.VISIBLE);
            register();
        }
    }

    private boolean validateRegister() {
        String name = txtName.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String cpf = txtCpf.getText().toString().trim();
        String phone = txtPhone.getText().toString().trim();
        String username = txtUser.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || cpf.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Favor preencha todos os campos para se cadastrar.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private UserInsertDTO getUserInsert() {
        String name = txtName.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String cpf = txtCpf.getText().toString().trim();
        String phone = txtPhone.getText().toString().trim();
        String username = txtUser.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        return new UserInsertDTO(name, cpf, email, phone, username, password);
    }

    private void register() {
        UserInsertDTO userInsert = getUserInsert();

        Call<Void> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(userInsert);

        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 201) {
                    Toast.makeText(RegisterActivity.this, "Cadastro efetuado com sucesso.", Toast.LENGTH_SHORT).show();
                    pbRegister.setVisibility(View.INVISIBLE);
                    onBackPressed();
                } else {
                    Toast.makeText(RegisterActivity.this, "", Toast.LENGTH_SHORT).show();
                    pbRegister.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Erro ao cadastrar, tente mais tarde." + t.getMessage(), Toast.LENGTH_SHORT).show();
                pbRegister.setVisibility(View.INVISIBLE);
            }
        });

    }
}
