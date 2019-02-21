package com.ilvdo.ilvdo_http_android.restclient;

/**
 * Created by sjy on 2018/12/24
 * Describe 请求类别
 */
public enum RestType {
    //post请求
    POST,
    //get 请求
    GET,
    //文件删除
    DELETE,
    //单文件上传
    FILE,
    //json上传
    JSON,
    // 文件参数混合上传
    FILE_MULTI

}
