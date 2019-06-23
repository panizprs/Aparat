package com.acm.workshop.aparat.app.executer

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BackgroundThread @Inject constructor(){
    val scheduler = Schedulers.io()
}