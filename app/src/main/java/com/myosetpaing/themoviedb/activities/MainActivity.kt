package com.myosetpaing.themoviedb.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.myosetpaing.themoviedb.R
import com.myosetpaing.themoviedb.adapters.PopularMovieRecyclerAdapter
import com.myosetpaing.themoviedb.di.Injection
import com.myosetpaing.themoviedb.viewmodel.PopularMovieViewModel
import com.myosetpaing.themoviedb.viewmodel.viewModelFactory.PopularMovieViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popularmovie_item_view.*

class MainActivity : AppCompatActivity() {

    private val mAdapter: PopularMovieRecyclerAdapter by lazy {
        PopularMovieRecyclerAdapter(applicationContext)
    }
    private val mViewModel: PopularMovieViewModel by lazy {
        ViewModelProviders.of(
            this,
            PopularMovieViewModelFactory(Injection.providePopularMovieRepository(applicationContext))
        ).get(PopularMovieViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPopularMovie.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = mAdapter
        }

        mViewModel.loadPopularMovieList()
        mViewModel.successState.observe(this, Observer {
            mAdapter.setData(it.toMutableList())

        })
        mViewModel.errorState.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()

        })

    }


}
