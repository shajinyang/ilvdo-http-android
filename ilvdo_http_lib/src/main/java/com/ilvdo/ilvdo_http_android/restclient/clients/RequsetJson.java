package com.ilvdo.ilvdo_http_android.restclient.clients;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ilvdo.ilvdo_http_android.callback.*;
import com.ilvdo.ilvdo_http_android.convert.ConvertUtil;
import com.ilvdo.ilvdo_http_android.retrofit.RetrofitCreator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.File;

/**
 * Created by sjy on 2018/12/25
 * Describe json请求 ，传实体类参数
 */
public class RequsetJson extends AbstractRequest {

    public RequsetJson(Object OBJECT_PARAM, String URL, File FILE, IOnSuccess ISUCCESS, IOnFailure IONFAILURE, IOnStart ISTART, IOnEnd IEND, IGetDisposable IGETDISPOSABLE, TypeReference CONVERT_BEAN) {
        super(OBJECT_PARAM, URL, FILE, ISUCCESS, IONFAILURE, ISTART, IEND, IGETDISPOSABLE, CONVERT_BEAN);
    }

    @Override
    public void start() {
        if(null==OBJECT_PARAM)return;
        if(null!=ISTART){
            ISTART.onStart();
        }
        String val= JSON.toJSONString(OBJECT_PARAM);
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),val);
        Disposable disposable= RetrofitCreator.Companion.getApiService()
                .postRaw(this.URL, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(null!=ISUCCESS){
                            if(CONVERT_BEAN!=null){
                                Object convertBean=ConvertUtil.json2JavaBean(s,CONVERT_BEAN);
                                if(convertBean!=null){
                                    ISUCCESS.onSuccess(convertBean);
                                }
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(null!=IONFAILURE){
                            IONFAILURE.onFailure(throwable);
                        }
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        if(null!=IEND){
                            IEND.onEnd();
                        }
                    }
                });
        if(null!=IGETDISPOSABLE){
            IGETDISPOSABLE.getDisposable(disposable);
        }
    }
}
