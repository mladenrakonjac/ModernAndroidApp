package me.fleka.modernandroidapp.data

import dagger.Module
import dagger.Provides
import me.fleka.modernandroidapp.androidmanagers.NetManager

@Module
class DataModule {

    @Provides
    fun providesGitRepoRepsitory(netManager: NetManager): GitRepoRepository {
        return GitRepoRepository(netManager)
    }
}