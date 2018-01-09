package com.shiwenping.rxmap.config

import android.content.Context
import com.shiwenping.rxmap.config.MapType

/**
 * Created by shiwenping on 17-12-27 上午10:44.
 *
 *  总体配置类
 */
open class BaseConfig(mapType: MapType) {
    /**
     * 初始化定位配置
     */
    open fun initLocation(context: Context) {
        //TODO:初始化
    }

    /**
     * 开始定位
     */
    open fun startLocation() {
        //TODO:开始定位
    }

    /**
     * 停止定位
     */
    open fun stopLocation() {
        //TODO:停止定位
    }

    open fun initPar(any: Any) {

    }

}