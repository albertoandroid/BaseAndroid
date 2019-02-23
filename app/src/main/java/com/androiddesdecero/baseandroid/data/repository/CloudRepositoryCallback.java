package com.androiddesdecero.baseandroid.data.repository;

import android.os.Bundle;
import android.util.Log;

import com.androiddesdecero.baseandroid.base.BaseCallback;
import com.androiddesdecero.baseandroid.base.BaseMapper;
import com.androiddesdecero.baseandroid.data.response.BaseResponse;
import com.androiddesdecero.baseandroid.util.MessageParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

public class CloudRepositoryCallback<T> implements Callback<T> {

    private BaseCallback baseCallback;
    private BaseMapper mapper;
    private String onFailureError;

    public String getOnFailureError() {
        return onFailureError;
    }

    public void setOnFailureError(String onFailureError) {
        this.onFailureError = onFailureError;
    }

    public BaseMapper getMapper() {
        return mapper;
    }

    public void setMapper(BaseMapper mapper) {
        this.mapper = mapper;
    }

    public BaseCallback getBaseCallback() {
        return baseCallback;
    }

    public void setBaseCallback(BaseCallback baseCallback) {
        this.baseCallback = baseCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.d("TAG1", "CallOnResponse");
        //int code = response == null? 0: response.code();
        //if(response!=null&&(code == 401 || code == 403)){
        if(isResponseError(response)){
            Log.d("TAG1", "errorCallOnResponse");
            baseCallback.onError(getResponseError(response), response.code());

        }else{
            Log.d("TAG1", "sucessCallOnResponse");
            baseCallback.onSuccess(mapper.map(response.body()), response.code());

        }
        baseCallback.always();
    }
    //}

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d("TAG1", "CallOnResponse-onFailure");
        baseCallback.onError(MessageParser.createBundle(onFailureError), null);
        baseCallback.always();
    }

    private boolean isResponseError(Response<T> response){
        boolean error = false;
        if(response != null && response.isSuccessful()){//rango 200-300
            if(response.body() instanceof BaseResponse){
                if(mapper != null){
                    if(mapper.isErrorResponse(response.body())){
                        error = true;
                    }
                } else {
                    error = true;
                }
            }
        }else{
            error = true;
        }
        return error;
    }

    private Bundle getResponseError(Response<T> response){
        Bundle operationErrorMessage = MessageParser.createBundle(onFailureError);//Error por defecto
        if(response.isSuccessful() && response.body() instanceof BaseResponse){
            if(mapper != null) {
                if (mapper.isErrorResponse(response.body())) {
                    Bundle responseMappedError = mapper.mapError(response.body(), operationErrorMessage);//Error in server response data
                    if(responseMappedError.getString(MessageParser.BUNDLE_TYPE) != null){
                        operationErrorMessage = responseMappedError;
                    }
                }
            }
        }
        return operationErrorMessage;
    }
}
