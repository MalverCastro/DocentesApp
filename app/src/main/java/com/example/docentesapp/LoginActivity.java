package com.example.docentesapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.docentesapp.api.ApiClient;
import com.example.docentesapp.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsuario, txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> login());
    }

    private void login() {

        String usuario = txtUsuario.getText().toString();
        String password = txtPassword.getText().toString();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<String> call = apiService.login(usuario, password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()) {

                    String resultado = response.body();

                    if(resultado != null && resultado.trim().equals("success")) {

                        Toast.makeText(LoginActivity.this,
                                "Login exitoso",
                                Toast.LENGTH_SHORT).show();

                    }
                    else {

                        Toast.makeText(LoginActivity.this,
                                "Usuario o contraseña incorrectos",
                                Toast.LENGTH_SHORT).show();

                    }

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(LoginActivity.this,
                        "Error de conexión",
                        Toast.LENGTH_SHORT).show();

            }
        });

    }

}