package com.test.ilvdo_http_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ilvdo.ilvdo_http_android.callback.*
import com.ilvdo.ilvdo_http_android.restclient.RestType
import com.ilvdo.ilvdo_http_android.restclient.RestClient
import com.test.ilvdo_http_android.bean.ReqBean
import com.test.ilvdo_http_android.bean.ResponseBean
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData(){
         RestClient
            .builder()
            .type(RestType.GET)
            .params("page","1")
            .params("count","5")
            .url("")
            .convert(String::class.java)
            .start(object :IOnStart{
                override fun onStart() {
                    Log.d("httpccc","开始")
                }
            })
            .success(object :IOnSuccess<ResponseBean>{
                override fun onSuccess(t: ResponseBean) {
                    val conStr=StringBuffer()
                    for (`a` in t.result){
                        conStr.append(a.title)
                            .append("\n")
                            .append(a.authors)
                            .append("\n")
                            .append(a.content)
                            .append("\n\n")
                    }
                    tv_content.text=conStr.toString()
                }
            })

            .failure(object : IOnFailure {
                override fun onFailure(throwable: Throwable) {
                    Log.d("httpccc",throwable.message)
                }
            })
            .end(object : IOnEnd {
                override fun onEnd() {
                    Log.d("httpccc","结束")
                }
            })
            .getDisposable(object :IGetDisposable{
                override fun getDisposable(disposable: Disposable) {

                }
            })
            .build()

    }


    private fun getData2(){

        val reqBean=ReqBean()
        reqBean.count="5"
        reqBean.page="1"

        RestClient
            .builder()
            .type(RestType.POST)
            .objParam(reqBean)
            .url("getSongPoetry")
            .convert(ResponseBean::class.java)
            .start(object :IOnStart{
                override fun onStart() {

                }
            })
            .success(object :IOnSuccess<ResponseBean>{
                override fun onSuccess(t: ResponseBean) {
                    val conStr=StringBuffer()
                    for (`a` in t.result){
                        conStr.append(a.title)
                            .append("\n")
                            .append(a.authors)
                            .append("\n")
                            .append(a.content)
                            .append("\n\n")
                    }
                    tv_content.text=conStr.toString()
                }
            })

            .failure(object : IOnFailure {
                override fun onFailure(throwable: Throwable) {

                }
            })
            .end(object : IOnEnd {
                override fun onEnd() {

                }
            })
            .getDisposable(object :IGetDisposable{
                override fun getDisposable(disposable: Disposable) {

                }
            })
            .build()

    }
    private fun getData3(){

        val reqBean=ReqBean()
        reqBean.count="5"
        reqBean.page="1"

        RestClient
            .builder()
            .type(RestType.JSON)
            .objParam(reqBean)
            .url("getSongPoetry")
            .convert(ResponseBean::class.java)
            .start(object :IOnStart{
                override fun onStart() {

                }
            })
            .success(object :IOnSuccess<ResponseBean>{
                override fun onSuccess(t: ResponseBean) {
                    val conStr=StringBuffer()
                    for (`a` in t.result){
                        conStr.append(a.title)
                            .append("\n")
                            .append(a.authors)
                            .append("\n")
                            .append(a.content)
                            .append("\n\n")
                    }
                    tv_content.text=conStr.toString()
                }
            })

            .failure(object : IOnFailure {
                override fun onFailure(throwable: Throwable) {

                }
            })
            .end(object : IOnEnd {
                override fun onEnd() {

                }
            })
            .getDisposable(object :IGetDisposable{
                override fun getDisposable(disposable: Disposable) {

                }
            })
            .build()

    }
}
