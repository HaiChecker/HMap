package com.shiwenping.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amap.api.location.AMapLocationClientOption
import com.baidu.location.LocationClientOption
import com.shiwenping.rxmap.RxMap
import com.shiwenping.rxmap.amap.AMapConfig
import com.shiwenping.rxmap.bdmap.BDMapConfig
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscription

class MainActivity : AppCompatActivity() {
    var map: com.shiwenping.rxmap.RxMap? = null
    var amapConfig: AMapConfig? = null
    var sub: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        map = RxMap()
        val mLocationOption = AMapLocationClientOption()
        mLocationOption.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        mLocationOption.interval = 1000
        mLocationOption.isNeedAddress = true
        amapConfig = AMapConfig(mLocationOption)

    }

    override fun onDestroy() {
        super.onDestroy()
        sub!!.dispose()
    }
}
