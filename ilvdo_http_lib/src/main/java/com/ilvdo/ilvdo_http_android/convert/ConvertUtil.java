package com.ilvdo.ilvdo_http_android.convert;

import com.alibaba.fastjson.JSON;

/**
 * Created by sjy on 2018/12/19
 * Describe  json转换  根据返回的字符串类型  转换不同类型
 */
public class ConvertUtil {

    public static  <T> T json2Bean(String s,Class<?> BEAN){
       if(null!=s){
           if(s.startsWith("{")&&s.endsWith("}")){
               return (T) JSON.parseObject(s,BEAN);
           }else if(s.startsWith("[")&&s.endsWith("]")){
               return (T) JSON.parseArray(s,BEAN);
           }
       }
       return null;
    }
}
