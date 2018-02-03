package me.fleka.modernandroidapp.utility.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerAwareViewModelFactory):
            ViewModelProvider.Factory
}