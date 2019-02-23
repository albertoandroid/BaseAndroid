package com.androiddesdecero.baseandroid.data.api;

import com.androiddesdecero.baseandroid.data.request.CrearCursoRequest;
import com.androiddesdecero.baseandroid.data.response.CrearCursoResponse;
import com.androiddesdecero.baseandroid.data.response.CursoResponse;
import com.androiddesdecero.baseandroid.data.response.CursoResponseArray;

import java.util.Currency;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

public interface WebServiceApi {

    @GET("/users/{user}/repos")
    Call<List<String>> getReposForUser(@Path("user") String user);

    @GET("/api/cursos")
    Call<CursoResponseArray[]> getCursos();

    @POST("/api/crear_curso")
    Call<Void> crearCurso(@Body CrearCursoRequest crearCursoRequest);
}
