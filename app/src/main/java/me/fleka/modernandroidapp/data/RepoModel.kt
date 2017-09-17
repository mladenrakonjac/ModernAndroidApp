package me.fleka.modernandroidapp.data

import android.os.Handler
import me.fleka.modernandroidapp.uimodels.Repository

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class RepoModel {

    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("new data") },2000)
    }

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 100, false))
        arrayList.add(Repository("Second", "Owner 2", 30, true))
        arrayList.add(Repository("Third", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) }, 2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data : String)
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}

