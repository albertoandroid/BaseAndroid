package com.androiddesdecero.baseandroid.di.module;

import android.content.Context;

import com.androiddesdecero.baseandroid.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

@Module
public class ApplicationModule {
    private BaseApplication application;

    public ApplicationModule(BaseApplication application){
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return application;
    }
}
