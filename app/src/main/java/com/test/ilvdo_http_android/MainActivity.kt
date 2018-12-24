package com.test.ilvdo_http_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ilvdo.ilvdo_http_android.callback.*
import com.ilvdo.ilvdo_http_android.restclient.RestClient
import com.test.ilvdo_http_android.bean.ResponseBean
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        Log.e("heh","")
    }

    private fun getData(){
         RestClient
            .builder()
            .params("page","1")
            .params("count","5")
            .url("getSongPoetry")
            .convert(ResponseBean::class.java)
            .start(object :IOnStart{
                override fun onStart() {

                }
            })
            .success(object :IOnSuccess<ResponseBean>{
                override fun onSuccess(t: ResponseBean) {
                    tv_content.text = t.message
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
            .get()

    }
}
