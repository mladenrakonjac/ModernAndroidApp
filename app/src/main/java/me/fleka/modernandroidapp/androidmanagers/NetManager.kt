package me.fleka.modernandroidapp.androidmanagers;

import android.content.Context
import android.net.ConnectivityManager

class NetManager(var applicationContext: Context) {

    val isConnectedToInternet: Boolean?
        get() {

            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager

            val ni = conManager.activeNetworkInfo
            return ni != null && ni.isConnected
        }
}