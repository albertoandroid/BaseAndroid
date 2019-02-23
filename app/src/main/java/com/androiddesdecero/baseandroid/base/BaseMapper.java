package com.androiddesdecero.baseandroid.base;

import android.os.Bundle;
import android.util.Log;

import com.androiddesdecero.baseandroid.data.response.BaseResponse;
import com.androiddesdecero.baseandroid.util.MessageParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

/*
BaseMapper-> Recibe unos datos de entrada del servidor y los convierte a los
datos que necesitamos en la app.
 */
public abstract class BaseMapper<T,R> {

    /*
    Metodo a sobreescribir en el Mapper de cada petición.
     */
    public abstract R map(T t);

    public Bundle mapError(T t, Bundle operationGenericError){
        Bundle errorBundle = operationGenericError;
        if(operationGenericError == null){
            errorBundle = MessageParser.createBundle(MessageParser.ERROR_GET_TOKEN);
        }
        return errorBundle;
    }

    public boolean isErrorResponse(T t){
        boolean isError = false;
        if(t instanceof BaseResponse){
            String errorResponse = ((BaseResponse) t).getMessageError();
            if(errorResponse != null){
                isError = true;
            }
        }
        return isError;
    }

    /*
    List<R> -> Será el dato a devolver, una lista de datos.
    List<T> -> Es la lista inicial (la que recibimos del servidor),
    la que con el map, se mapea a la nueva lista con los datos validos para la app.
     */
    public List<R> map(List<? extends Serializable> initalList){
        List<R> list = new ArrayList<>();
        if(initalList != null){
            Log.d("TAG1", initalList.size() + "");
            for(int i =0; i< initalList.size(); i++){
                list.add(map((T) initalList.get(i)));
            }
        }
        return list;
    }
}
