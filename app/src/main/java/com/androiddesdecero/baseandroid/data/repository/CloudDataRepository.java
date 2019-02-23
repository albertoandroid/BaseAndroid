package com.androiddesdecero.baseandroid.data.repository;


import android.util.Log;

import com.androiddesdecero.baseandroid.base.BaseCallback;
import com.androiddesdecero.baseandroid.base.BaseMapper;
import com.androiddesdecero.baseandroid.data.api.WebService;
import com.androiddesdecero.baseandroid.data.api.WebServiceApi;
import com.androiddesdecero.baseandroid.data.request.CrearCursoRequest;
import com.androiddesdecero.baseandroid.data.response.CrearCursoResponse;
import com.androiddesdecero.baseandroid.data.response.CursoResponseArray;
import com.androiddesdecero.baseandroid.mapper.CrearCursoMapper;
import com.androiddesdecero.baseandroid.mapper.CursosArrayMapper;
import com.androiddesdecero.baseandroid.util.MessageParser;

import java.util.List;

import retrofit2.Call;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

public class CloudDataRepository implements DataRepository {
    @Override
    public void getLogin(String user, BaseCallback callback) {

    }

    @Override
    public void getCursos(BaseCallback callback) {

    }

    @Override
    public void getCursosArray(BaseCallback callback) {
        WebServiceApi client = WebService.getInstance().createService(WebServiceApi.class);
        Call<CursoResponseArray[]> call = client.getCursos();
        enqueueCall(call, MessageParser.ERROR_GET_CURSOS_ARRAY, callback, new CursosArrayMapper(), new CloudRepositoryCallback<CursoResponseArray[]>());

    }

    @Override
    public void postCrearCurso(CrearCursoRequest crearCursoRequest, BaseCallback callback) {
        WebServiceApi client = WebService.getInstance().createService(WebServiceApi.class);
        Call<Void> call = client.crearCurso(crearCursoRequest);
        enqueueCall(call, MessageParser.ERROR_CREAR_CURSO, callback, new CrearCursoMapper(), new CloudRepositoryCallback<Void>());
    }

    protected static <T> void enqueueCall(Call<T> call, String defaultOnFailureError, BaseCallback baseCallback, BaseMapper mapper, CloudRepositoryCallback<T> callback){
        Log.d("TAG1", "hOLA");
        callback.setOnFailureError(defaultOnFailureError);
        callback.setBaseCallback(baseCallback);
        callback.setMapper(mapper);
        call.enqueue(callback);
    }
}
