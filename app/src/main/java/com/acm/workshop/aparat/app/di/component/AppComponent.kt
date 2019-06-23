package com.acm.workshop.aparat.app.di.component

import com.acm.workshop.aparat.app.AparatApp
import com.acm.workshop.aparat.app.di.module.AppModule
import com.acm.workshop.aparat.app.di.module.DataBaseModule
import com.acm.workshop.aparat.app.di.module.FragmentsModule
import com.acm.workshop.aparat.app.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        DataBaseModule::class,
        FragmentsModule::class
    ]
)
interface AppComponent : AndroidInjector<AparatApp>{

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<AparatApp>

}