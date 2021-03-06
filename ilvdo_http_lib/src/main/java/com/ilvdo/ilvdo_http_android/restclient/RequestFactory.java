package com.ilvdo.ilvdo_http_android.restclient;

import com.alibaba.fastjson.TypeReference;
import com.ilvdo.ilvdo_http_android.callback.*;
import com.ilvdo.ilvdo_http_android.restclient.clients.*;

import java.io.File;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by sjy on 2018/12/24
 * Describe 网络请求 简单工厂类
 */
public class RequestFactory {

    public static AbstractRequest create(
            WeakHashMap<String,Object> PARAMS
            ,RestType requestType
            , Object OBJECT_PARAM
            , String URL
            , List<File> FILE
            , IOnSuccess ISUCCESS
            , IOnFailure IONFAILURE
            , IOnStart ISTART
            , IOnEnd IEND
            , IGetDisposable IGETDISPOSABLE
            , TypeReference CONVERT_BEAN){
        switch (requestType){
            case GET:
                return new RequestGet(PARAMS,OBJECT_PARAM, URL, FILE, ISUCCESS, IONFAILURE, ISTART, IEND, IGETDISPOSABLE, CONVERT_BEAN);
            case POST:
                return new RequestPost(PARAMS,OBJECT_PARAM, URL, FILE, ISUCCESS, IONFAILURE, ISTART, IEND, IGETDISPOSABLE, CONVERT_BEAN);
            case JSON:
                return new RequsetJson(PARAMS,OBJECT_PARAM, URL, FILE, ISUCCESS, IONFAILURE, ISTART, IEND, IGETDISPOSABLE, CONVERT_BEAN);
            case FILE:
                return new RequestFiles(PARAMS,OBJECT_PARAM, URL, FILE, ISUCCESS, IONFAILURE, ISTART, IEND, IGETDISPOSABLE, CONVERT_BEAN);


        }

        return null;
    }
}
