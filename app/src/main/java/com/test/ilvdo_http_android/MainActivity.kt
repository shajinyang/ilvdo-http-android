package com.test.ilvdo_http_android

import android.os.Bundle
import android.os.Environment
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
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import java.io.File

/**
 * Created by sjy on 2019/2/11
 * Describe
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uploadFile()
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


    private fun  uploadFile(){
        RestClient
            .builder()
            .type(RestType.FILE)
            .file(File(Environment.getExternalStorageDirectory().absolutePath+"/letter.svg"))
            .file(File(Environment.getExternalStorageDirectory().absolutePath+"/letter.svg"))
            .url("http://47.104.99.118:8093/api/v3/qy/TelMachine/SubmitTelMAttachment")
            .convertType(object : TypeReference<CommonBean<String>>() {

            })
            .success { _ ->

            }
            .build()
    }
}
