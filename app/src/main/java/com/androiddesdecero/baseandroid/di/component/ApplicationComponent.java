package com.androiddesdecero.baseandroid.di.component;

import com.android.application.di.module.RepositoryModule;
import com.androiddesdecero.baseandroid.base.BaseActivity;
import com.androiddesdecero.baseandroid.di.module.ApplicationModule;
import com.androiddesdecero.baseandroid.model.usecase.BaseUseCase;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    void inject(BaseUseCase baseUseCase);
}
