package com.acm.workshop.aparat.app.ui.home

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.acm.workshop.aparat.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment(){

    @Inject
    lateinit var homeViewModelFactory : HomeViewModelFactory

    private val homeViewModel by lazy{
        ViewModelProviders.of(this, homeViewModelFactory)[HomeViewModel::class.java]
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        println("onCreateView")
        return inflater.inflate(R.layout.recyclerview_list, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeViewModel.getVideos()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val loadingBar = view.findViewById<View>(R.id.loadingBar)

        homeViewModel.videos.observe(this, Observer {videos ->
            recyclerView.adapter = HomeAdapter(videos)
            loadingBar.visibility = View.GONE
        })

        homeViewModel.error.observe(this, Observer {error ->
            Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
        })

        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(context, "Last", Toast.LENGTH_LONG).show()

                }
            }
        })



    }

}