package com.acm.workshop.aparat.data.repository

import com.acm.workshop.aparat.app.executer.BackgroundThread
import com.acm.workshop.aparat.app.executer.MainThread
import com.acm.workshop.aparat.data.entity.AparatEntity
import com.acm.workshop.aparat.data.entity.VideoEntity
import com.acm.workshop.aparat.local.datasource.VideosLocalDataSource
import com.acm.workshop.aparat.local.model.toVideoEntity
import com.acm.workshop.aparat.remote.datasource.VideosRemoteDataSource
import com.acm.workshop.aparat.remote.dto.VideosDto
import com.acm.workshop.aparat.remote.dto.toApartEntity
import com.acm.workshop.aparat.remote.dto.toLocalVideo
import com.acm.workshop.aparat.remote.dto.toVideoEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class VideosRepository @Inject constructor(
    private val videoRemoteDataSource: VideosRemoteDataSource,
    private val videoLocalDataSource: VideosLocalDataSource,
    private val mainThread: MainThread,
    private val backgroundThread: BackgroundThread
) {

    private val disposables = CompositeDisposable()

    fun getVideos(page: String, onSuccess: (AparatEntity) -> Unit, onFailure: (Throwable) -> Unit) {
//        videoLocalDataSource.listAllVideos()
//            .subscribeOn(backgroundThread.scheduler)
//            .observeOn(mainThread.scheduler)
//            .doOnSuccess { localVideos ->
//                println("localdatas")
//                onSuccess(
//                    AparatEntity(
//                        localVideos.map { localVideo ->
//                            localVideo.toVideoEntity()
//                        }, null
//                    )
//                )
//            }
//            .observeOn(backgroundThread.scheduler)
//            .doOnSuccess {
//
                videoRemoteDataSource.getVideos(page)
                    .subscribeOn(Schedulers.io())
                    .doOnSuccess { videosDto ->
                        videosDto.mostviewedvideos.forEach { mostViewedVideos ->
                            videoLocalDataSource.insertVideo(mostViewedVideos.toLocalVideo())
                        }
                        //                videoLocalDataSource.listAllVideos().subscribe({
                        //                    println("database size: ${it.size}")
                        //                },{
                        //                    println("error ${it.message}")
                        //                })
                    }
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
//            }
    }

}
