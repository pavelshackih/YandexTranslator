package io.pavelshackih.yandextranslator.ext.rx

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface RxScheduler {
    fun getNetwork(): Scheduler
    fun getComputation(): Scheduler
    fun getMain(): Scheduler
}

class RxSchedulerImpl : RxScheduler {

    override fun getNetwork(): Scheduler = Schedulers.io()

    override fun getComputation(): Scheduler = Schedulers.computation()

    override fun getMain(): Scheduler = AndroidSchedulers.mainThread()
}

fun <T> Single<T>.switchNetwork(rxScheduler: RxScheduler): Single<T> =
        this.subscribeOn(rxScheduler.getNetwork())
                .observeOn(rxScheduler.getMain())

fun <T> Single<T>.switchComputation(rxScheduler: RxScheduler): Single<T> =
        this.subscribeOn(rxScheduler.getComputation())
                .observeOn(rxScheduler.getMain())