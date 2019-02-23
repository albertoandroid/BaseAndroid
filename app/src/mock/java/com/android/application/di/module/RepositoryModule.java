package com.android.application.di.module;

import com.androiddesdecero.baseandroid.data.repository.DataRepository;
import com.androiddesdecero.baseandroid.data.repository.MockDataRepository;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */
/*
Este modulo nos sirve para inyecta el DataRepository correcto.
En este caso el de datos MOCK.
 */
@Module
public class RepositoryModule {
    private DataRepository dataRepository;

    public RepositoryModule(){
        this.dataRepository = new MockDataRepository(new Gson());
    }

    @Provides
    @Singleton
    DataRepository provideRepositoryModule(){
        return dataRepository;
    }
}
