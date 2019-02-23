package com.androiddesdecero.baseandroid.data.response;

import java.io.Serializable;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

/*
Los datos de respuesta según lo vamos a recibir del servidor.
En este caso la respuesa sera para el Error
 */
public class BaseResponse implements Serializable {

    //"error" viene el json este campo
    private String error;

    public String getMessageError() {
        return error;
    }

    public void setMessageError(String messageError) {
        this.error = messageError;
    }
}
