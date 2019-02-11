package com.ilvdo.ilvdo_http_android.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * Created by sjy on 2018/12/19
 * Describe  json转换  根据返回的字符串类型  转换不同类型
 */
public class ConvertUtil {

    @Deprecated
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

    /**
     * json 转javabean类
     * @param s json字符串
     * @param type
     * @param <T>
     * @return
     */
    public static  <T> T json2JavaBean(String s,Class<T> type){
        if(null!=s){
            return JSON.parseObject(s,new TypeReference<T>(type){});
        }
        return null;
    }
}
