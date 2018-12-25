package com.ilvdo.ilvdo_http_android.restclient;

import com.ilvdo.ilvdo_http_android.callback.*;

import java.io.File;

/**
 * Created by sjy on 2018/12/18
 * Describe
 */
public class RestClient {

    public RestClient(
            RestType requestType
            , Object OBJECT_PARAM
            , String URL
            , File FILE
            , IOnSuccess ISUCCESS
            , IOnFailure IONFAILURE
            , IOnStart ISTART
            , IOnEnd IEND
            , IGetDisposable IGETDISPOSABLE
            , Class<?> CONVERT_BEAN
    ) {
        RequestFactory.create(
                requestType
                ,  OBJECT_PARAM
                ,  URL
                ,  FILE
                ,  ISUCCESS
                ,  IONFAILURE
                ,  ISTART
                ,  IEND
                ,  IGETDISPOSABLE
                ,  CONVERT_BEAN
                )
                .start();
    }


    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }



}
