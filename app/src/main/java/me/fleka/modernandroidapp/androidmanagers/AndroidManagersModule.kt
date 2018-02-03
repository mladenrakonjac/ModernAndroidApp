package me.fleka.modernandroidapp.androidmanagers

import dagger.Module
import dagger.Provides
import me.fleka.modernandroidapp.ModernApplication
import javax.inject.Singleton

@Module
class AndroidManagersModule {

    @Singleton
    @Provides
    fun providesNetManager(applicationContext: ModernApplication): NetManager {
        return NetManager(applicationContext)
    }
}