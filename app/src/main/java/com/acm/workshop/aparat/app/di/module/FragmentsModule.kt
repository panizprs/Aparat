package com.acm.workshop.aparat.app.di.module

import com.acm.workshop.aparat.app.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule{

    @ContributesAndroidInjector
    abstract fun homeFragment() : HomeFragment

}