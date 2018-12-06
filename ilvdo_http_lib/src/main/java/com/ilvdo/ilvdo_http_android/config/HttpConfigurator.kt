package com.ilvdo.ilvdo_http_android.config

import android.app.Application
import okhttp3.Interceptor
import java.lang.RuntimeException
import java.util.*

/**
 * Created by sjy on 2018/12/5
 * Describe 全局配置类
 */
class HttpConfigurator private constructor(){

    private val HTTP_CONFIGS = Hashtable<Any, Any>()
    private val INTERCEPTORS = HashSet<Interceptor>()
    private val NETWORK_INTERCEPTORS = HashSet<Interceptor>()


    init {
        //开始配置标记
        HTTP_CONFIGS[ConfigKeys.CONFIG_READY]=false
    }

    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder= HttpConfigurator()
    }

    /**
     * 设置Http主域名
     */
    fun  withApiHost(url:String): HttpConfigurator {
        HTTP_CONFIGS[ConfigKeys.API_HOST] = url
        return this
    }

    /**
     * 设置拦截器,可配置多个
     */
    fun withIntercept(interceptor: Interceptor): HttpConfigurator {
        INTERCEPTORS.add(interceptor)
        HTTP_CONFIGS[ConfigKeys.INTERCEPT]=INTERCEPTORS
        return this
    }

    /**
     * 设置拦截器,可配置多个
     */
    fun withNetIntercept(interceptor: Interceptor): HttpConfigurator {
        NETWORK_INTERCEPTORS.add(interceptor)
        HTTP_CONFIGS[ConfigKeys.NETWORK_INTERCEPT]=NETWORK_INTERCEPTORS
        return this
    }

    /**
     * 设置application
     */
    fun withApplication(application: Application):HttpConfigurator{
        HTTP_CONFIGS[ConfigKeys.APPLICATION_CONTEXT]=application
        return this
    }


    fun config(){
        HTTP_CONFIGS[ConfigKeys.CONFIG_READY]=true
    }


    /**
     * 检查配置是否完成
     */
    private fun checkConfig(){
        val isReady =getConfig<Boolean>(ConfigKeys.CONFIG_READY)
        if(!isReady){
            throw RuntimeException("Configuration is not not ready,please config http first")
        }
    }


    /**
     * 获取配置
     */
    fun <T> getConfig(key: ConfigKeys):T{
        checkConfig()
        return HTTP_CONFIGS[key] as T
    }


}