package com.ilvdo.ilvdo_http_android.restclient.clients;

import com.alibaba.fastjson.TypeReference;
import com.ilvdo.ilvdo_http_android.callback.*;
import com.ilvdo.ilvdo_http_android.convert.ConvertUtil;
import com.ilvdo.ilvdo_http_android.restclient.util.ReflectUtil;
import com.ilvdo.ilvdo_http_android.retrofit.RetrofitCreator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.io.File;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by sjy on 2018/12/24
 * Describe post 请求
 */
public class RequestPost extends AbstractRequest {

    public RequestPost(WeakHashMap<String,Object> PARAMS,Object OBJECT_PARAM, String URL, List<File> FILE, IOnSuccess ISUCCESS, IOnFailure IONFAILURE, IOnStart ISTART, IOnEnd IEND, IGetDisposable IGETDISPOSABLE, TypeReference CONVERT_BEAN) {
        super( PARAMS,OBJECT_PARAM, URL, FILE, ISUCCESS, IONFAILURE, ISTART, IEND, IGETDISPOSABLE, CONVERT_BEAN);
    }

    @Override
    public void start() {

        if(null!=ISTART){
            ISTART.onStart();
        }

        if(null!=OBJECT_PARAM){
            WeakHashMap<String,Object> hm= ReflectUtil.getFiledsInfo(OBJECT_PARAM);
            PARAMS.putAll(hm);
        }

        Disposable disposable= RetrofitCreator.Companion.getApiService()
                .post(this.URL, this.PARAMS)
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
