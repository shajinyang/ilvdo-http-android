package com.test.ilvdo_http_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.alibaba.fastjson.TypeReference
import com.ilvdo.ilvdo_http_android.callback.IOnSuccess
import com.ilvdo.ilvdo_http_android.restclient.ConvertBean
import com.ilvdo.ilvdo_http_android.restclient.RestClient
import com.ilvdo.ilvdo_http_android.restclient.RestType
import com.test.ilvdo_http_android.bean.CommonBean
import com.test.ilvdo_http_android.bean.ResponseBean

/**
 * Created by sjy on 2019/2/11
 * Describe
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        RestClient
            .builder()
            .type(RestType.GET)
            .params("page", "1")
            .params("count", "5")
            .url("")
            .convertType(object : TypeReference<CommonBean<List<ResponseBean>>>() {

            })
            .success { _ ->

            }
            .build()

    }
}
