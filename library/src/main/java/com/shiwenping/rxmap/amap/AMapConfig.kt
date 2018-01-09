package com.shiwenping.rxmap.amap

import android.content.Context
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.shiwenping.rxmap.LocationData
import com.shiwenping.rxmap.RxBus
import com.shiwenping.rxmap.config.BaseConfig
import com.shiwenping.rxmap.config.MapType

/**
 * Created by shiwenping on 17-12-27 上午10:43.
 *
 *
 */
class AMapConfig(var par: AMapLocationClientOption) : BaseConfig(MapType.AMAP) {

    var client: AMapLocationClient? = null

    override fun initLocation(context: Context) {
        super.initLocation(context)

        client = AMapLocationClient(context)

        client!!.setLocationOption(par)

        client!!.setLocationListener {
            val location = LocationData()
            location.amapData = it
            location.isStartd = true
            location.mapType = MapType.AMAP
            RxBus.default.post(location)
        }

    }

    override fun initPar(any: Any) {
        super.initPar(any)
        client!!.setLocationOption(any as AMapLocationClientOption?)
    }

    override fun startLocation() {
        super.startLocation()
        client!!.startLocation()
    }
}