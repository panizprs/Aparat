package com.acm.workshop.aparat.data.repository

import com.acm.workshop.aparat.app.executer.BackgroundThread
import com.acm.workshop.aparat.app.executer.MainThread
import com.acm.workshop.aparat.data.entity.AparatEntity
import com.acm.workshop.aparat.data.entity.VideoEntity
import com.acm.workshop.aparat.remote.datasource.VideosRemoteDataSource
import com.acm.workshop.aparat.remote.dto.VideosDto
import com.acm.workshop.aparat.remote.dto.toApartEntity
import com.acm.workshop.aparat.remote.dto.toVideoEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class VideosRepository @Inject constructor(
    private val videoRemoteDataSource: VideosRemoteDataSource,
    private val mainThread: MainThread,
    private val backgroundThread: BackgroundThread
    ) {

    private val disposables = CompositeDisposable()

    fun getVideos(page: String, onSuccess: (AparatEntity) -> Unit, onFailure: (Throwable) -> Unit) {
        println("videoRepository")
        videoRemoteDataSource.getVideos(page)
            .subscribeOn(backgroundThread.scheduler)
            .observeOn(mainThread.scheduler)
            .subscribe({ videosDto ->
                println("subscribe $videosDto")
                onSuccess(
                    videosDto.toApartEntity()
                    )
            }, { error ->
                println("error:  $error")
                onFailure(error)
            }).addTo(disposables)
    }

}
