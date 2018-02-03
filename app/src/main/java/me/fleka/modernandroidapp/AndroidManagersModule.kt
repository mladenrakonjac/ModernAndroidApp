package me.fleka.modernandroidapp

import dagger.Module
import dagger.Provides
import me.fleka.modernandroidapp.androidmanagers.NetManager
import javax.inject.Singleton

/**
 * Created by Mladen Rakonjac on 2/3/18.
 */
@Module
class AndroidManagersModule {

    @Singleton
    @Provides
    fun providesNetManager(applicationContext: ModernApplication): NetManager {
        return NetManager(applicationContext)
    }
}