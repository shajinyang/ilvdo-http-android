package com.ilvdo.ilvdo_http_android.restclient;

import com.alibaba.fastjson.JSON;
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
 * Created by sjy on 2018/12/18
 * Describe
 */
public class RestClient {

    public RestClient(
            WeakHashMap<String,Object> PARAMS
            ,RestType requestType
            , Object OBJECT_PARAM
            , String URL
            , List<File> FILES
            , IOnSuccess ISUCCESS
            , IOnFailure IONFAILURE
            , IOnStart ISTART
            , IOnEnd IEND
            , IGetDisposable IGETDISPOSABLE
            , TypeReference typeReference
    ) {
        RequestFactory.create(PARAMS,requestType, OBJECT_PARAM, URL, FILES, ISUCCESS, IONFAILURE, ISTART, IEND, IGETDISPOSABLE, typeReference)
                .start();
    }


    public static   RestClientBuilder builder(){
        return new RestClientBuilder();
    }

}
