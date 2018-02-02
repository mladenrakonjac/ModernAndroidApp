package me.fleka.modernandroidapp

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import me.fleka.modernandroidapp.data.GitRepoRepository

/**
 * Created by Mladen Rakonjac on 2/2/18.
 */
class MainViewModelFactory(private val repository: GitRepoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}