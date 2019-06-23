package com.acm.workshop.aparat.app.di.module

import com.acm.workshop.aparat.app.AparatApp
import dagger.Module
import dagger.Provides


@Module
class AppModule{

    @Provides
    fun provideContext(app: AparatApp) = app.applicationContext

}