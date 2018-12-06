package com.ilvdo.ilvdo_http_android.retrofit

import android.net.sip.SipErrorCode.TIME_OUT
import com.ilvdo.ilvdo_http_android.config.ConfigKeys
import com.ilvdo.ilvdo_http_android.config.HttpConfigurator
import com.ilvdo.ilvdo_http_android.retrofit.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by sjy on 2018/12/5
 * Describe 构建retrofit
 */
class RetrofitCreator {

    companion object {

        fun getApiService():ApiService{
            return ApiServiceHolder.holder
        }

        fun getParams():WeakHashMap<String,Any>{
            return ParamsHolder.PARAMS
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