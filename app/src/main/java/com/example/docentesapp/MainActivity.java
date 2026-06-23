package com.example.docentesapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docentesapp.api.ApiClient;
import com.example.docentesapp.api.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerDocentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerDocentes = findViewById(R.id.recyclerDocentes);
        recyclerDocentes.setLayoutManager(new LinearLayoutManager(this));

        cargarDocentes();
    }

    private void cargarDocentes() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Docente>> call = apiService.listarDocentes();

        call.enqueue(new Callback<List<Docente>>() {

            @Override
            public void onResponse(Call<List<Docente>> call, Response<List<Docente>> response) {

                if(response.isSuccessful() && response.body() != null) {

                    List<Docente> lista = response.body();

                    DocenteAdapter adapter = new DocenteAdapter(lista);

                    recyclerDocentes.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Docente>> call, Throwable t) {

                Toast.makeText(MainActivity.this,
                        "Error al cargar docentes",
                        Toast.LENGTH_LONG).show();

            }
        });

    }

}



