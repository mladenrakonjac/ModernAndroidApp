package me.fleka.modernandroidapp

import android.content.Context
import me.fleka.modernandroidapp.androidmanagers.NetManager
import me.fleka.modernandroidapp.data.GitRepoRepository

/**
 * Created by Mladen Rakonjac on 2/2/18.
 */
object Injection {

    private var NET_MANAGER: NetManager? = null

    private fun provideNetManager(context: Context): NetManager {
        if (NET_MANAGER == null) {
            NET_MANAGER = NetManager(context)
        }
        return NET_MANAGER!!
    }

    private fun gitRepoRepository(netManager: NetManager): GitRepoRepository {
        return GitRepoRepository(netManager)
    }

    fun provideMainViewModelFactory(context: Context): MainViewModelFactory {
        val netManager = provideNetManager(context)
        val repository = gitRepoRepository(netManager)
        return MainViewModelFactory(repository)
    }

}