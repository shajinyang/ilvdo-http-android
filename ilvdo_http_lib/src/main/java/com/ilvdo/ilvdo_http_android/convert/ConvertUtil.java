package com.ilvdo.ilvdo_http_android.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * Created by sjy on 2018/12/19
 * Describe  json转换  根据返回的字符串类型  转换不同类型
 */
public class ConvertUtil {

    /**
     * json 转 javabean
     * 但是在实际使用过程中，通用性不强，无法转换泛形参数
     * @param s
     * @param BEAN
     * @param <T>
     * @return
     */
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
     * json 转javabean类，支持泛形反序列化
     * @param s json字符串
     * @param <T>
     * @return
     */
    public  static   <T> T json2JavaBean(String s,TypeReference<T> typeReference){
        if(null!=s){
            return JSON.parseObject(s,typeReference);
        }
        return null;
    }
}
