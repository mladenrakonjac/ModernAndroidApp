package me.fleka.modernandroidapp.data

import dagger.Module
import dagger.Provides
import me.fleka.modernandroidapp.androidmanagers.NetManager
import me.fleka.modernandroidapp.data.GitRepoRepository

/**
 * Created by Mladen Rakonjac on 2/3/18.
 */
@Module
class DataModule {

    @Provides
    fun providesGitRepoRepsitory(netManager: NetManager): GitRepoRepository {
        return GitRepoRepository(netManager)
    }
}