package com.androiddesdecero.baseandroid.model.usecase;

import com.androiddesdecero.baseandroid.base.BaseCallback;
import com.androiddesdecero.baseandroid.data.request.CrearCursoRequest;

/**
 * Created by albertopalomarrobledo on 23/2/19.
 */

public class CrearCursoUseCase extends BaseUseCase {
    public void getData(CrearCursoRequest cursoRequest, BaseCallback callback){
        repository.postCrearCurso(cursoRequest, callback);
    }
}
