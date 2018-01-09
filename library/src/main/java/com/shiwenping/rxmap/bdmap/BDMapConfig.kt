package com.shiwenping.rxmap.bdmap

import android.content.Context
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.shiwenping.rxmap.LocationData
import com.shiwenping.rxmap.RxBus
import com.shiwenping.rxmap.config.BaseConfig
import com.shiwenping.rxmap.config.MapType

/**
 * Created by shiwenping on 17-12-27 上午10:44.
 *
 *  百度定位配置类
 *
 */
class BDMapConfig(var par: LocationClientOption) : BaseConfig(MapType.BDMAP) {
    var client: LocationClient? = null
    override fun initLocation(context: Context) {
        super.initLocation(context)
        client = LocationClient(context, par)
        client!!.registerNotifyLocationListener {
            run {
                val location = LocationData()
                location.isStartd = true
                location.mapType = MapType.BDMAP
                location.bdmapData = it
                RxBus.default.post(location)

            }
        }
    }

    override fun startLocation() {
        super.startLocation()
        client!!.start()
    }
}