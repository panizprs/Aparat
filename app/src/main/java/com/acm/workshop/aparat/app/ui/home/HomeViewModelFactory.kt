package com.acm.workshop.aparat.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acm.workshop.aparat.data.repository.VideosRepository
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val repository: VideosRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }

}