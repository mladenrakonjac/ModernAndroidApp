package me.fleka.modernandroidapp.data

import io.reactivex.Observable
import me.fleka.modernandroidapp.androidmanagers.NetManager
import me.fleka.modernandroidapp.uimodels.Repository

/**
 * Repository for GitHub Repository models
 */
class GitRepoRepository(private val netManager: NetManager) {

    private val localDataSource = GitRepoLocalDataSource()
    private val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories(): Observable<ArrayList<Repository>> {

        netManager.isConnectedToInternet?.let {
            if (it) {
                //todo save those data to local data store
                return remoteDataSource.getRepositories()
            }
        }

        return localDataSource.getRepositories()
    }
}



