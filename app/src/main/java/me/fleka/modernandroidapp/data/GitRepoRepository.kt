package me.fleka.modernandroidapp.data

import android.content.Context
import me.fleka.modernandroidapp.androidmanagers.NetManager
import me.fleka.modernandroidapp.uimodels.Repository

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class GitRepoRepository(context: Context) {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()
    val netManager = NetManager(context)

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        remoteDataSource.getRepositories(object : OnRepoRemoteReadyCallback {
            override fun onRemoteDataReady(data: ArrayList<Repository>) {
                netManager.isConnectedToInternet?.let {
                    if (it) {
                        localDataSource.saveRepositories(data)
                        onRepositoryReadyCallback.onDataReady(data)
                    } else {
                        localDataSource.getRepositories(object : OnRepoLocalReadyCallback {
                            override fun onLocalDataReady(data: ArrayList<Repository>) {
                                onRepositoryReadyCallback.onDataReady(data)
                            }
                        })
                    }
                }
            }

        })
    }
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}

