package com.shiwenping.rxmap

import android.content.Context
import com.shiwenping.rxmap.config.BaseConfig
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe
import io.reactivex.schedulers.Schedulers

/**
 * Created by shiwenping on 17-12-27 上午10:38.
 *
 *  定位类
 */
class RxMap {
    fun <T : BaseConfig> rxMap(config: T, context: Context): Flowable<LocationData> {
        return Flowable.create(FlowableOnSubscribe<LocationData> { e ->
            config.initLocation(context)
            config.startLocation()

            RxBus.default.toFlowable(LocationData::class.java)
                    .subscribe({ data ->
                        e.onNext(data)
                    }, { e.onError(it) }, { e.onComplete() })

        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
    }

}