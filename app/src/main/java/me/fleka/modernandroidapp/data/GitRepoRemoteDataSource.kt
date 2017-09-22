package me.fleka.modernandroidapp.data

import android.os.Handler
import me.fleka.modernandroidapp.uimodels.Repository

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class GitRepoRemoteDataSource {

    fun getRepositories(onRepositoryReadyCallback: OnRepoRemoteReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First from remote", "Owner 1", 100, false))
        arrayList.add(Repository("Second from remote", "Owner 2", 30, true))
        arrayList.add(Repository("Third from remote", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) }, 2000)
    }
}

interface OnRepoRemoteReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}