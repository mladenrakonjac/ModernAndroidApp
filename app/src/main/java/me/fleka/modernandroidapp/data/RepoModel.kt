package me.fleka.modernandroidapp.data

import android.os.Handler

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class RepoModel {

    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("new data") },2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data : String)
}
