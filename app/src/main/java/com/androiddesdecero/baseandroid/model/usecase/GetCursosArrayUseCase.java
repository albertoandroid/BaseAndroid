package com.androiddesdecero.baseandroid.model.usecase;

import com.androiddesdecero.baseandroid.base.BaseCallback;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

public class GetCursosArrayUseCase extends BaseUseCase {
    public void getData(BaseCallback callback){
        repository.getCursosArray(callback);
    }
}
