package com.ilvdo.ilvdo_http_android.restclient;

import com.ilvdo.ilvdo_http_android.callback.*;
import com.ilvdo.ilvdo_http_android.retrofit.RetrofitCreator;

import java.io.File;
import java.util.WeakHashMap;

/**
 * Created by sjy on 2018/12/18
 * Describe
 */
public class RestClientBuilder {
    private WeakHashMap<String,Object> PARAMS = RetrofitCreator.Companion.getParams();
    private  Object OBJECT_PARAM;
    private  String URL;
    private  File FILE;
    private  IOnSuccess ISUCCESS;
    private  IOnFailure IONFAILURE;
    private  IOnStart ISTART;
    private  IOnEnd IEND;
    private  IGetDisposable IGETDISPOSABLE;
    private  Class<?> CONVERT_BEAN;
    private RestType REQUEST_TYPE;

    public RestClientBuilder params(String key,Object value){
        PARAMS.put(key,value);
        return this;
    }

    public RestClientBuilder objParam(Object objParam){
        this.OBJECT_PARAM=objParam;
            return this;
    }

    public RestClientBuilder type(RestType requestType){
        this.REQUEST_TYPE=requestType;
        return this;
    }

    public RestClientBuilder url(String url){
            this.URL=url;
            return this;
    }

    public RestClientBuilder convert(Class<?> CONVERT_BEAN){
        this.CONVERT_BEAN=CONVERT_BEAN;
        return this;
    }
    public RestClientBuilder file(File file){
            this.FILE=file;
            return this;
    }

    public RestClientBuilder start(IOnStart iOnStart){
        this.ISTART=iOnStart;
        return this;
    }
    public RestClientBuilder success(IOnSuccess iOnSuccess){
        this.ISUCCESS=iOnSuccess;
        return this;
    }
    public RestClientBuilder failure(IOnFailure iOnFailure){
        this.IONFAILURE=iOnFailure;
        return this;
    }
    public RestClientBuilder end(IOnEnd iOnEnd){
        this.IEND=iOnEnd;
        return this;
    }
    public RestClientBuilder getDisposable(IGetDisposable iGetDisposable){
        this.IGETDISPOSABLE=iGetDisposable;
        return this;
    }



    public RestClient build(){
        return new RestClient(
                REQUEST_TYPE
                ,OBJECT_PARAM
                , URL
                , FILE
                , ISUCCESS
                , IONFAILURE
                , ISTART
                , IEND
                , IGETDISPOSABLE
                , CONVERT_BEAN
                );
    }
}
