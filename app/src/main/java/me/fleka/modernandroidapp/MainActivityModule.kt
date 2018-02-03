package me.fleka.modernandroidapp

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import me.fleka.modernandroidapp.data.GitRepoRepository

/**
 * Created by mladenrakonjac on 02/10/17.
 */
@Module
internal abstract class MainActivityModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun providesViewModelFactory(gitRepoRepository: GitRepoRepository):
                MainViewModelFactory = MainViewModelFactory(gitRepoRepository)

    }

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity

}