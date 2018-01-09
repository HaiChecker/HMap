package com.shiwenping.rxmap

import io.reactivex.Flowable
import io.reactivex.processors.FlowableProcessor
import io.reactivex.processors.PublishProcessor

/**
 * Created by shiwenping on 17-12-27 上午11:30.
 *
 *
 */
class RxBus private constructor() {
    private val mBus: FlowableProcessor<Any>

    init {
        mBus = PublishProcessor.create()
    }

    fun post(obj: Any) {
        mBus.onNext(obj)
    }

    fun <T> toFlowable(tClass: Class<T>): Flowable<T> {
        return mBus.ofType(tClass)
    }

    fun toFlowable() : Flowable<Any>
    {
        return mBus
    }

    fun hasSubscribers(): Boolean {
        return mBus.hasSubscribers()
    }

    private object Holder {
        val BUS = RxBus()
    }

    companion object {
        val default: RxBus
            get() = Holder.BUS
    }
}