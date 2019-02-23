package com.androiddesdecero.baseandroid.data.response;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

/*
La respuesta que recibimos por parte del Servidor.
En este caso recibimos un Objeto data, que dentro tiene un objeto token.
{
  "data": {
    "token": "tokengu"
  },
  "error": null
}
 */
public class LoginResponse extends BaseResponse{

    private DataLoginRequest data;

    public static class DataLoginRequest{
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public DataLoginRequest getData() {
        return data;
    }

    public void setData(DataLoginRequest data) {
        this.data = data;
    }
}
