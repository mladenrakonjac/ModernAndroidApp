package me.fleka.modernandroidapp

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import me.fleka.modernandroidapp.data.OnRepositoryReadyCallback
import me.fleka.modernandroidapp.data.GitRepoRepository
import me.fleka.modernandroidapp.uimodels.Repository

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
class MainViewModel : ViewModel() {
    var gitRepoRepository: GitRepoRepository = GitRepoRepository()

    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        gitRepoRepository.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}