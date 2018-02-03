package me.fleka.modernandroidapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Mladen Rakonjac on 2/3/18.
 */
class ModernApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}