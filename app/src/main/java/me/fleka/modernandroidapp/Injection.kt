package me.fleka.modernandroidapp

import android.content.Context
import me.fleka.modernandroidapp.androidmanagers.NetManager
import me.fleka.modernandroidapp.data.GitRepoRepository

/**
 * Created by Mladen Rakonjac on 2/2/18.
 */
object Injection {

    fun provideMainViewModelFactory(context: Context): MainViewModelFactory {
        val netManager = NetManager(context)
        val repository = GitRepoRepository(netManager)
        return MainViewModelFactory(repository)
    }
}