package com.example.docentesapp.api;

import com.example.docentesapp.Docente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    // LOGIN
    @GET("login.php")
    Call<String> login(
            @Query("username") String username,
            @Query("password") String password
    );

    // LISTAR DOCENTES
    @GET("listarDocentes.php")
    Call<List<Docente>> listarDocentes();

    // GUARDAR DOCENTE
    @POST("guardarDocente.php")
    Call<String> guardarDocente(
            @Query("nombre") String nombre,
            @Query("apellidos") String apellidos,
            @Query("email") String email,
            @Query("telefono") String telefono,
            @Query("blog") String blog,
            @Query("profesional") String profesional,
            @Query("escalafon") String escalafon,
            @Query("idioma") String idioma,
            @Query("anosExperiencia") int anosExperiencia,
            @Query("areaTrabajo") String areaTrabajo
    );

    // ACTUALIZAR DOCENTE
    @POST("actualizarDocente.php")
    Call<String> actualizarDocente(
            @Query("id") int id,
            @Query("nombre") String nombre,
            @Query("apellidos") String apellidos,
            @Query("email") String email,
            @Query("telefono") String telefono,
            @Query("blog") String blog,
            @Query("profesional") String profesional,
            @Query("escalafon") String escalafon,
            @Query("idioma") String idioma,
            @Query("anosExperiencia") int anosExperiencia,
            @Query("areaTrabajo") String areaTrabajo
    );

    // ELIMINAR DOCENTE
    @POST("eliminarDocente.php")
    Call<String> eliminarDocente(
            @Query("id") int id
    );

}