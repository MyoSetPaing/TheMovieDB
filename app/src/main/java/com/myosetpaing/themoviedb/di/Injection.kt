package com.myosetpaing.themoviedb.di

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.myosetpaing.themoviedb.AppConstant
import com.myosetpaing.themoviedb.CustomOKHttpInterceptor
import com.myosetpaing.themoviedb.data.dataSource.PopularMovieDataSource
import com.myosetpaing.themoviedb.data.repository.PopularMovieRepository
import com.myosetpaing.themoviedb.networks.api.MovieApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Injection {
    private lateinit var customOKHttpInterceptor: CustomOKHttpInterceptor

    fun provideApiService(): MovieApi {
        customOKHttpInterceptor = CustomOKHttpInterceptor()
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(customOKHttpInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(MovieApi::class.java)
    }

    fun providePopularMovieRepository(context: Context): PopularMovieDataSource {
        return PopularMovieRepository(context, provideApiService())

    }


}