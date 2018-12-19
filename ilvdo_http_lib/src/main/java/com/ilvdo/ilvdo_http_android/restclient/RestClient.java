package com.ilvdo.ilvdo_http_android.restclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.ilvdo.ilvdo_http_android.callback.*;
import com.ilvdo.ilvdo_http_android.convert.ConvertUtil;
import com.ilvdo.ilvdo_http_android.retrofit.RetrofitCreator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.io.File;
import java.util.WeakHashMap;

/**
 * Created by sjy on 2018/12/18
 * Describe
 */
public class RestClient {
    private final WeakHashMap<String,Object> PARAMS = RetrofitCreator.Companion.getParams();
    private final Object OBJECT_PARAM;
    private final String URL;
    private final File FILE;
    private final IOnSuccess ISUCCESS;
    private final IOnFailure IONFAILURE;
    private final IOnStart ISTART;
    private final IOnEnd IEND;
    private final IGetDisposable IGETDISPOSABLE;
    private final Class<?> CONVERT_BEAN;


    public RestClient(Object OBJECT_PARAM, String URL, File FILE, IOnSuccess ISUCCESS, IOnFailure IONFAILURE, IOnStart ISTART, IOnEnd IEND, IGetDisposable IGETDISPOSABLE, Class<?> CONVERT_BEAN) {
        this.OBJECT_PARAM = OBJECT_PARAM;
        this.URL = URL;
        this.FILE = FILE;
        this.ISUCCESS = ISUCCESS;
        this.IONFAILURE = IONFAILURE;
        this.ISTART = ISTART;
        this.IEND = IEND;
        this.IGETDISPOSABLE = IGETDISPOSABLE;
        this.CONVERT_BEAN = CONVERT_BEAN;
    }


    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }


    /**
     * get请求
     */
    public void get(){
        if(null!=ISTART){
            ISTART.onStart();
        }
        Disposable disposable= RetrofitCreator.Companion.getApiService()
                .get(this.URL, this.PARAMS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(null!=ISUCCESS){
                            if(CONVERT_BEAN!=null){
                                if(ConvertUtil.json2Bean(s,CONVERT_BEAN)!=null){
                                    ISUCCESS.onSuccess(ConvertUtil.json2Bean(s,CONVERT_BEAN));
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

    /**
     * post请求
     */
    public void post(){
        if(null!=ISTART){
            ISTART.onStart();
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
                                if(ConvertUtil.json2Bean(s,CONVERT_BEAN)!=null){
                                    ISUCCESS.onSuccess(ConvertUtil.json2Bean(s,CONVERT_BEAN));
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

    /**
     * post json 表单
     */
    public void postJson(){

    }
}
