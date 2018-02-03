package me.fleka.modernandroidapp

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Mladen Rakonjac on 2/3/18.
 */
@Module
class AppModule {

    @Provides
    fun providesContext(application: ModernApplication): Context {
        return application.applicationContext
    }
}