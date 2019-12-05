package com.myosetpaing.themoviedb

import android.app.Application
import com.myosetpaing.themoviedb.data.dataSource.PopularMovieDataSource
import com.myosetpaing.themoviedb.data.repository.PopularMovieRepository
import com.myosetpaing.themoviedb.di.Injection.provideApiService
import com.myosetpaing.themoviedb.networks.api.MovieApi
import com.myosetpaing.themoviedb.viewmodel.viewModelFactory.PopularMovieViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*

class TheMovieApplication: Application(),KodeinAware{
    override val kodein: Kodein = Kodein.lazy {

        import(androidXModule(this@TheMovieApplication))

        bind<MovieApi>() with singleton { provideApiService() }
        bind<PopularMovieDataSource>() with singleton { PopularMovieRepository(applicationContext,instance()) }
        bind() from provider { PopularMovieViewModelFactory(instance()) }


    }

    override fun onCreate() {
        super.onCreate()
        val k = Kodein

    }
}