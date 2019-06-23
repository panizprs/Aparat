package com.acm.workshop.aparat.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.aparat.data.entity.AparatEntity
import com.acm.workshop.aparat.data.entity.VideoEntity
import com.acm.workshop.aparat.data.repository.VideosRepository
import com.acm.workshop.aparat.remote.api.VideosService.Companion.BASE_URL_SIZE


class HomeViewModel(private val repository: VideosRepository) : ViewModel() {

    private var nextPage : String? = null

    private val _videos = MutableLiveData<List<VideoEntity>>()
    val videos : LiveData<List<VideoEntity>> = _videos

    private val _error = MutableLiveData<Throwable>()
    val error : LiveData<Throwable> = _error

    fun getVideos() {
        println("getVideos")
        repository.getVideos("/etc/api/mostviewedvideos", ::successGetVideos, ::failGetVideos)
    }

    private fun successGetVideos(aparatEntity: AparatEntity) {
        println(aparatEntity.videos.size)
        _videos.value = aparatEntity.videos
        nextPage = aparatEntity.nextPage
    }

    private fun failGetVideos(throwable: Throwable) {
        println(throwable.message)
        _error.value = throwable
    }


    fun loadNextPageVideos(){
        nextPage?.let {page ->
            repository.getVideos(page.substring(BASE_URL_SIZE , page.length), ::successGetVideos, ::failGetVideos)
        }
    }
}
