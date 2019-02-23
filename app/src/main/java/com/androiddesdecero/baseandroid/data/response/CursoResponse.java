package com.androiddesdecero.baseandroid.data.response;

import android.util.Log;

import java.util.List;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

/*
La respuesta que recibimos por parte del Servidor.
En este caso recibimos un Objeto data, que dentro tiene un objeto token.
{
  "curso":
  [
    {
      "curso_id": 1,
      "nombre": "Curso Retrofit",
      "profesorId": 8
    },
    {
      "curso_id": 2,
      "nombre": "Curso iOS",
      "profesorId": 11
    },
    {
      "curso_id": 3,
      "nombre": "Curso Java",
      "profesorId": 11
    },
    {
      "curso_id": 4,
      "nombre": "Curso Kotlin",
      "profesorId": 11
    }
  ]
}
 */
public class CursoResponse extends BaseResponse {

    private List<DataCamposCursoResponse> curso;

    public List<DataCamposCursoResponse> getCurso() {
        return curso;
    }

    public void setCurso(List<DataCamposCursoResponse> curso) {
        this.curso = curso;
    }

    public static class DataCamposCursoResponse{
        private String curso_id;
        private String nombre;

        public String getCurso_id() {
            return curso_id;
        }

        public void setCurso_id(String curso_id) {
            this.curso_id = curso_id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
}
