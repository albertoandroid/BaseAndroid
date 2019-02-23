package com.android.application.di.module;

import android.provider.ContactsContract;

import com.androiddesdecero.baseandroid.data.repository.CloudDataRepository;
import com.androiddesdecero.baseandroid.data.repository.DataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

@Module
public class RepositoryModule {

    private final DataRepository dataRepository;

    public RepositoryModule(){
        this.dataRepository = new CloudDataRepository();
    }

    @Provides
    @Singleton
    DataRepository provideRepositoryModule(){
        return dataRepository;
    }
}
