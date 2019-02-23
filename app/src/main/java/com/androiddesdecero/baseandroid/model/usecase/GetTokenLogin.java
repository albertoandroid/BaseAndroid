package com.androiddesdecero.baseandroid.model.usecase;

import com.androiddesdecero.baseandroid.base.BaseCallback;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */
/*
Esta es la Clase para hacer la petición de Obetner el Token.
Hay que indicar los parametros de Entrada, en este caso String user y callback.
 */
public class GetTokenLogin extends BaseUseCase {
    public void getData(String user, BaseCallback callback) {
        repository.getLogin(user, callback);
    }
}
