package me.fleka.modernandroidapp

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.fleka.modernandroidapp.androidmanagers.AndroidManagersModule
import me.fleka.modernandroidapp.ui.screens.main.MainActivityModule
import me.fleka.modernandroidapp.utility.di.ViewModelBuilder
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidSupportInjectionModule::class,
            AppModule::class,
            AndroidManagersModule::class,
            ViewModelBuilder::class,
            MainActivityModule::class])
interface AppComponent : AndroidInjector<ModernApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ModernApplication>()
}