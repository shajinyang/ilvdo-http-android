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
    // 多文件上传
    FILES,
    //json上传
    JSON,
    // 单文件参数混合上传
    FILE_MULTI,
    //多文件参数混合上传
    FILES_MULTI,
    // 单文件参数混合上传，文件为键值的方式
    FILE_MULTI_MAP,
    //多文件参数混合上传,文件为键值的方式
    FILES_MULTI_MAP,
    // put请求
    PUT

}
