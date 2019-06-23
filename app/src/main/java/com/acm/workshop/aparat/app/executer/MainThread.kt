package com.acm.workshop.aparat.app.executer

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainThread @Inject constructor() {
    var scheduler = AndroidSchedulers.mainThread()
}