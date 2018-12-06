package com.ilvdo.ilvdo_http_android

import android.app.Application
import com.ilvdo.ilvdo_http_android.config.HttpConfigurator

/**
 * Created by sjy on 2018/12/5
 * Describe 网络请求库初始化类
 */

class  IlvdoHttp {

    companion object {
        /**
         * 项目初始化
         */
        fun init(application: Application):HttpConfigurator{
            return HttpConfigurator
                .instance
                .withApplication(application)
        }
    }


}