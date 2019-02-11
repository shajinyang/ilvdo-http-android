package com.test.ilvdo_http_android;

import com.ilvdo.ilvdo_http_android.callback.*;
import com.ilvdo.ilvdo_http_android.restclient.RestClient;
import com.ilvdo.ilvdo_http_android.restclient.RestType;
import com.test.ilvdo_http_android.bean.ReqBean;
import com.test.ilvdo_http_android.bean.ResponseBean;
import io.reactivex.disposables.Disposable;
import org.jetbrains.annotations.NotNull;

/**
 * Created by sjy on 2019/2/11
 * Describe
 */
public class Test {
    public void testJava(ReqBean reqBean){
        RestClient
                .builder()
                .type(RestType.POST) //请求方式，可切换 get  post  json 等等
                .objParam(reqBean) //对象传参
                .url("test/test/") //接口路径
                .convert(ResponseBean.class) //接受的实体类
                .start(new IOnStart() {
                    @Override
                    public void onStart() {

                    }
                })
                .success(new IOnSuccess<ResponseBean>() {
                    @Override
                    public void onSuccess(ResponseBean o) {

                    }
                })
                .failure(new IOnFailure() {
                    @Override
                    public void onFailure(@NotNull Throwable throwable) {

                    }
                })
                .end(new IOnEnd() {
                    @Override
                    public void onEnd() {

                    }
                })
                .getDisposable(new IGetDisposable() {
                    @Override
                    public void getDisposable(@NotNull Disposable disposable) {

                    }
                })
                .build();
    }
}
