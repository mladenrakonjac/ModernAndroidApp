package me.fleka.modernandroidapp.data

import me.fleka.modernandroidapp.uimodels.Repository

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class GitRepoRepository {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()


    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        remoteDataSource.getRepositories(object : OnRepoRemoteReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                localDataSource.saveRepositories(data)
                onRepositoryReadyCallback.onDataReady(data)
            }

        })
    }
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}

