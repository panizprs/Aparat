package com.acm.workshop.aparat.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.acm.workshop.aparat.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment(){

    @Inject
    lateinit var homeViewModelFactory : HomeViewModelFactory

    val homeViewModel by lazy{
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

}