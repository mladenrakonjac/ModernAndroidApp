package me.fleka.modernandroidapp.data

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import me.fleka.modernandroidapp.uimodels.Repository
import java.util.concurrent.TimeUnit

/**
 * Data source for GitHub Repositories from local DB
 * Currently, we fake the data for the sake of the simplicity
 */
class GitRepoLocalDataSource {

    fun getRepositories(): Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First From Local", "Owner 1", 100, false))
        arrayList.add(Repository("Second From Local", "Owner 2", 30, true))
        arrayList.add(Repository("Third From Local", "Owner 3", 430, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>): Completable {
        return Single.just(1).delay(1, TimeUnit.SECONDS).toCompletable()
    }
}
