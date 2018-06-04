package me.mladenrakonjac.modernandroidapp

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.mladenrakonjac.modernandroidapp.ui.screens.main.MainActivityModule
import me.mladenrakonjac.modernandroidapp.utility.di.ViewModelBuilder
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidSupportInjectionModule::class,
            AppModule::class,
            ViewModelBuilder::class,
            MainActivityModule::class])
interface AppComponent : AndroidInjector<ModernApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ModernApplication>()
}