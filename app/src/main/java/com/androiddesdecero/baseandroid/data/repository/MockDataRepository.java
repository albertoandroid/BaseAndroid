package com.androiddesdecero.baseandroid.data.repository;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.androiddesdecero.baseandroid.base.BaseApplication;
import com.androiddesdecero.baseandroid.base.BaseCallback;
import com.androiddesdecero.baseandroid.base.BaseMapper;
import com.androiddesdecero.baseandroid.data.request.CrearCursoRequest;
import com.androiddesdecero.baseandroid.data.response.CrearCursoResponse;
import com.androiddesdecero.baseandroid.data.response.CursoResponse;
import com.androiddesdecero.baseandroid.data.response.CursoResponseArray;
import com.androiddesdecero.baseandroid.data.response.LoginResponse;
import com.androiddesdecero.baseandroid.mapper.CrearCursoMapper;
import com.androiddesdecero.baseandroid.mapper.CursosArrayMapper;
import com.androiddesdecero.baseandroid.mapper.CursosMapper;
import com.androiddesdecero.baseandroid.mapper.LoginMapper;
import com.androiddesdecero.baseandroid.util.MessageParser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

/*
Nos convierte el json que tenemos en el archivo Asset, en unos datos como se si recibieran
desde un servidor o una base de datos local.
Solo valido para Mock
 */
public class MockDataRepository implements DataRepository {

    private Gson gson;

    public MockDataRepository(Gson gson){
        this.gson = gson;
    }

    //El String user es solo valido, para las peticiones reales, en el mock, no hace nada, pero hay que ponerlo.
    @Override
    public void getLogin(String user, BaseCallback callback) {
        processMockRequest("mockdata.json", MessageParser.ERROR_GET_TOKEN, new LoginMapper(), LoginResponse.class, 2000, callback);
    }

    @Override
    public void getCursos(BaseCallback callback) {
        processMockRequest("cursos.json", MessageParser.ERROR_GET_CURSOS, new CursosMapper(), CursoResponse.class, 2000, callback);
    }

    @Override
    public void getCursosArray(BaseCallback callback) {
        processMockRequest("cursos_a.json", MessageParser.ERROR_GET_CURSOS_ARRAY, new CursosArrayMapper(), CursoResponseArray[].class, 2000, callback);
    }

    @Override
    public void postCrearCurso(CrearCursoRequest crearCursoRequest, BaseCallback callback) {
        processMockRequest("crearcursoa.json", MessageParser.ERROR_CREAR_CURSO, new CrearCursoMapper(), CrearCursoResponse.class, 2000, callback);
    }


    /*
    localFileName -> file with data in json format
    errorType -> error type si la opercion falla
    mapper -> concierte los datos de la respuesta en los datos de la app
    clazz -> La clase de Respuesta que será parseada con Gson
    delayInMs -> El tiempo de retraso en la ejecución del callback. Recuerda que estamos simulando un acceso a webservice
    callback -> callback que será llamado despues de obtener los datos.
                si todo correcto se llamara al metodo onSuccess
     */
    private void processMockRequest(String localFileName, final String errorType, final BaseMapper mapper, final Class clazz, final long delayInMs, final BaseCallback baseCallback){
        Log.d("TAG1", "hola");

        try{
            final Bundle operationErrorMessage = MessageParser.createBundle(errorType);
            final String serverResponseString = readAsset(localFileName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Handler mainHandler = new Handler(Looper.getMainLooper());
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            try{
                                Log.d("TAG1", "Hola2");
                                Object response = gson.fromJson(serverResponseString, clazz);
                                Log.d("TAG1", "Hola3 " + response.toString());
                                if(mapper.isErrorResponse(response)){
                                    Log.d("TAG1", "Hola4 ");
                                    Bundle errorMsg = mapper.mapError(response, operationErrorMessage);
                                    if(errorMsg.getString(MessageParser.BUNDLE_TYPE) == null){
                                        Log.d("TAG1", "Hola4 + Error");
                                        errorMsg.putString(MessageParser.BUNDLE_TYPE, errorType);
                                    }
                                    Log.d("TAG1", "Hola4 + Error + " + errorMsg.getString(MessageParser.BUNDLE_TYPE));
                                    baseCallback.onError(mapper.mapError(response, operationErrorMessage), null);
                                }else{
                                    Log.d("TAG1", "Hola5 ");
                                    baseCallback.onSuccess(mapper.map(response), HttpURLConnection.HTTP_OK);
                                    Log.d("TAG1", "Hola6 ");
                                }
                            }catch (Exception e){
                                requestError(errorType, baseCallback, e);
                            }
                            baseCallback.always();
                        }
                    };
                    mainHandler.postDelayed(runnable, delayInMs);
                }
            }).start();

        }catch (IOException e){
            requestError(errorType, baseCallback, e);
        }

    }

    private String readAsset(String assetsName) throws IOException{
        String fileContent = "";
        AssetManager assetManager = BaseApplication.getAppContext().getAssets();
        InputStream in;
        in = assetManager.open(assetsName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine())!=null){
            sb.append(line).append("\n");
        }
        reader.close();
        fileContent = sb.toString();
        in.close();
        in = null;
        return fileContent;
    }

    private void requestError(String errorType, BaseCallback callback, Exception e){
        e.printStackTrace();
        callback.onError(MessageParser.createBundle(errorType), null);
    }

}

















