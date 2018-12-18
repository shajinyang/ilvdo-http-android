package com.test.ilvdo_http_android

import android.app.Application
import com.ilvdo.ilvdo_http_android.IlvdoHttp

/**
 * Created by sjy on 2018/12/5
 * Describe
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        IlvdoHttp.init(this)
            .withApiHost("https://api.apiopen.top/")
            .logEnable(true)
            .config()
    }
}