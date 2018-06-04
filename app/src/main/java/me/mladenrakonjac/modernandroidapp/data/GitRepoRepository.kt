package me.mladenrakonjac.modernandroidapp.data

import io.reactivex.Observable
import me.mladenrakonjac.modernandroidapp.androidmanagers.NetManager
import me.mladenrakonjac.modernandroidapp.ui.uimodels.Repository
import javax.inject.Inject

/**
 * Repository for GitHub Repository models
 */
class GitRepoRepository @Inject constructor(var netManager: NetManager) {

    private val localDataSource = GitRepoLocalDataSource()
    private val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories(): Observable<ArrayList<Repository>> {

        netManager.isConnectedToInternet?.let {
            if (it) {
                return remoteDataSource.getRepositories().flatMap {
                    return@flatMap localDataSource.saveRepositories(it)
                            .toSingleDefault(it)
                            .toObservable()
                }
            }
        }

        return localDataSource.getRepositories()
    }
}



