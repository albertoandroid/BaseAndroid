package com.androiddesdecero.baseandroid.model.usecase;

import com.android.application.di.module.RepositoryModule;
import com.androiddesdecero.baseandroid.data.repository.DataRepository;
import com.androiddesdecero.baseandroid.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

/*
Injectamos el repositorio.
En este caso utilizamos Dagger para inyectar la opción correcta.
 */
public abstract class BaseUseCase {

    @Inject
    public DataRepository repository;

    public BaseUseCase(){
        DaggerApplicationComponent.builder()
                .repositoryModule(new RepositoryModule())
                .build()
                .inject(this);
    }
}
