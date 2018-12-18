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
    //打印日志标识，默认不打印
    private var LOG_ENABLE=false

    init {
        //开始配置标记
        HTTP_CONFIGS[ConfigKeys.CONFIG_READY]=false
        HTTP_CONFIGS[ConfigKeys.INTERCEPT]=INTERCEPTORS
        HTTP_CONFIGS[ConfigKeys.NETWORK_INTERCEPT]=NETWORK_INTERCEPTORS
        HTTP_CONFIGS[ConfigKeys.ENABLE_LOG]=LOG_ENABLE
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

    /**
     * 设置是否打印日志
     */
    fun logEnable(enable:Boolean):HttpConfigurator{
        HTTP_CONFIGS[ConfigKeys.ENABLE_LOG]=enable
        return this
    }


    fun config(){
        HTTP_CONFIGS[ConfigKeys.CONFIG_READY]=true
    }


    /**
     * 检查配置是否完成
     */
    private fun checkConfig(){
        val isReady =HTTP_CONFIGS[ConfigKeys.CONFIG_READY] as Boolean
        if(!isReady){
            throw RuntimeException("Configuration is not not ready,please config http first")
        }
    }


    /**
     * 获取配置
     */
    fun <T> getConfig(key: Any):T{
        checkConfig()
        return HTTP_CONFIGS[key] as T
    }


}