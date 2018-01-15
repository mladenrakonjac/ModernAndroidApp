package me.fleka.modernandroidapp

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import me.fleka.modernandroidapp.androidmanagers.NetManager
import me.fleka.modernandroidapp.data.GitRepoRepository
import me.fleka.modernandroidapp.uimodels.Repository

/**
 * View Model
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetManager(getApplication()))

    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    private val compositeDisposable: CompositeDisposable? = CompositeDisposable()


    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable?.add(gitRepoRepository.getRepositories().subscribeWith(object : DisposableObserver<ArrayList<Repository>>() {

            override fun onError(e: Throwable) {
                //if some error happens in our data layer our app will not crash, we will
                // get error here
            }

            override fun onNext(data: ArrayList<Repository>) {
                repositories.value = data
            }

            override fun onComplete() {
                isLoading.set(false)
            }
        }))
    }

    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable != null && !compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}