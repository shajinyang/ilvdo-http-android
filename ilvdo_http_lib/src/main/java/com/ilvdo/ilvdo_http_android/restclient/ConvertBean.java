package com.ilvdo.ilvdo_http_android.restclient;

import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;

/**
 * Created by sjy on 2019/2/11
 * Describe
 */
public class ConvertBean<T> {
    public TypeReference convert(){
        return new TypeReference<T>(){};
    }
}
