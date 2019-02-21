package com.ilvdo.ilvdo_http_android.retrofit

import android.net.sip.SipErrorCode.TIME_OUT
import android.util.Log
import com.ilvdo.ilvdo_http_android.config.ConfigKeys
import com.ilvdo.ilvdo_http_android.config.HttpConfigurator
import com.ilvdo.ilvdo_http_android.retrofit.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * Created by sjy on 2018/12/5
 * Describe 构建retrofit
 */
class RetrofitCreator private constructor(){

    companion object {

        fun getApiService():ApiService{
            return ApiServiceHolder.holder
        }

        fun getParams():WeakHashMap<String,Any>{
            var p=ParamsHolder.PARAMS
            p.clear()
            return p
        }
    }

    /**
     * 参数单例
     */
    private object ParamsHolder{
        val PARAMS = WeakHashMap<String, Any>()
    }


    /**
     * okhttp client 单例
     */
    private object OkhttpHolder{
        private val TIME_OUT = 60
        private val BUILDER = OkHttpClient.Builder()
        private val INTERCEPTORS = HttpConfigurator.instance.getConfig<HashSet<Interceptor>>(ConfigKeys.INTERCEPT)
        private val NETWORK_INTERCEPTORS =HttpConfigurator.instance.getConfig<HashSet<Interceptor>>(ConfigKeys.NETWORK_INTERCEPT)
        private val LOG_ENABLE=HttpConfigurator.instance.getConfig<Boolean>(ConfigKeys.ENABLE_LOG)

        private fun addInterceptor(): OkHttpClient.Builder {
            if (!INTERCEPTORS.isEmpty()) {
                for (`in` in INTERCEPTORS) {
                    BUILDER.addInterceptor(`in`)
                }
            }
            if (!NETWORK_INTERCEPTORS.isEmpty()) {
                for (interceptor in NETWORK_INTERCEPTORS) {
                    BUILDER.addNetworkInterceptor(interceptor)
                }
            }
            //打印日志
            if(LOG_ENABLE){
                val logInterceptor = HttpLoggingInterceptor( HttpLoggingInterceptor.Logger{
                    Log.d("OkHttp",it)
                })
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                BUILDER.addNetworkInterceptor(logInterceptor)
            }

            return BUILDER
        }

        val holder:OkHttpClient = addInterceptor()
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    /**
     * retrofit 单例
     */
    private object RetrofitHolder{
        private val BASE_URL = HttpConfigurator.instance.getConfig<String>(ConfigKeys.API_HOST)
        val holder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkhttpHolder.holder)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    /**
     * api service单例
      */
    private object ApiServiceHolder{
        val holder:ApiService=RetrofitHolder.holder.create(ApiService::class.java)
    }

}