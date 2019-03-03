package com.ilvdo.ilvdo_http_android.restclient.clients;

import com.alibaba.fastjson.TypeReference;
import com.ilvdo.ilvdo_http_android.callback.*;
import com.ilvdo.ilvdo_http_android.retrofit.RetrofitCreator;

import java.io.File;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by sjy on 2018/12/24
 * Describe
 */
public abstract class AbstractRequest {
    protected  WeakHashMap<String,Object> PARAMS ;
    protected  Object OBJECT_PARAM;
    protected  String URL;
    protected  List<File> FILE;
    protected  IOnSuccess ISUCCESS;
    protected  IOnFailure IONFAILURE;
    protected  IOnStart ISTART;
    protected  IOnEnd IEND;
    protected  IGetDisposable IGETDISPOSABLE;
    protected  TypeReference CONVERT_BEAN;

    public AbstractRequest(WeakHashMap<String,Object> PARAMS , Object OBJECT_PARAM, String URL, List<File> FILE, IOnSuccess ISUCCESS, IOnFailure IONFAILURE, IOnStart ISTART, IOnEnd IEND, IGetDisposable IGETDISPOSABLE, TypeReference CONVERT_BEAN) {
        this.PARAMS=PARAMS;
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

    public abstract void  start();
}
