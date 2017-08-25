package me.fleka.modernandroidapp

import me.fleka.modernandroidapp.data.OnDataReadyCallback
import me.fleka.modernandroidapp.data.RepoModel

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class MainViewModel {
    var repoModel: RepoModel = RepoModel()
    var text: String = ""
    var isLoading: Boolean = false

    val onDataReadyCallback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            text = data
        }
    }

    fun refresh() {
        repoModel.refreshData(onDataReadyCallback)
    }
}