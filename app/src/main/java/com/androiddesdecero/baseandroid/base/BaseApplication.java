package com.androiddesdecero.baseandroid.base;

import android.app.Application;
import android.content.Context;

import com.androiddesdecero.baseandroid.di.component.ApplicationComponent;
import com.androiddesdecero.baseandroid.di.component.DaggerApplicationComponent;
import com.androiddesdecero.baseandroid.di.module.ApplicationModule;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

public class BaseApplication extends Application {

    private static Context context;

    private ApplicationComponent applicationComponent;

    public BaseApplication(){
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    public static Context getAppContext(){
        return BaseApplication.context;
    }
}
