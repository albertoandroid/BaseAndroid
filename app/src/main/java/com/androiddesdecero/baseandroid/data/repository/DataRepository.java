package com.androiddesdecero.baseandroid.data.repository;

import com.androiddesdecero.baseandroid.base.BaseCallback;
import com.androiddesdecero.baseandroid.data.request.CrearCursoRequest;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

/*
En la interfaz de Data Repository, tenemos todos los metodos get de Datos que necesitamos.
Luego será implementada según la fuente.
Fuente -> Mock, QA, PRO.
 */
public interface DataRepository {

    void getLogin(String user, BaseCallback callback);
    void getCursos(BaseCallback callback);
    void getCursosArray(BaseCallback callback);
    void postCrearCurso(CrearCursoRequest crearCursoRequest, BaseCallback callback);

}
