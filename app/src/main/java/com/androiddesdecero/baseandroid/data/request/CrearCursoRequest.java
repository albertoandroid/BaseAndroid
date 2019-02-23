package com.androiddesdecero.baseandroid.data.request;

/**
 * Created by albertopalomarrobledo on 23/2/19.
 */

public class CrearCursoRequest {

    private String nombre;
    private String profesor_id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(String profesor_id) {
        this.profesor_id = profesor_id;
    }
}
