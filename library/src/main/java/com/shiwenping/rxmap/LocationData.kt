package com.shiwenping.rxmap

import com.amap.api.location.AMapLocation
import com.baidu.location.BDLocation
import com.shiwenping.rxmap.config.MapType

/**
 * Created by shiwenping on 17-12-27 上午11:16.
 *
 * 定位数据类,高德,百度定位数据
 *
 */
class LocationData {

    //是否开始定位
    var isStartd: Boolean = false
    //地图类型,默认高德地图
    var mapType: MapType = MapType.AMAP
    //高德地图定位数据
    var amapData: AMapLocation? = null
    //百度地图定位数据
    var bdmapData: BDLocation? = null

}