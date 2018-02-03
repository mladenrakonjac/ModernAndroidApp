package me.fleka.modernandroidapp

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mladenrakonjac on 02/10/17.
 */
@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity

}