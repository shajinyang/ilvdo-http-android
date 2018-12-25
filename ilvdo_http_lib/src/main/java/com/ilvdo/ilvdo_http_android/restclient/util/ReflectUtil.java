package com.ilvdo.ilvdo_http_android.restclient.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by sjy on 2018/12/25.
 */

public class ReflectUtil {
    /**
     * 获取对象的属性-值  map集合
     * @param o
     * @return
     */
    public static WeakHashMap<String,Object> getFiledsInfo(Object o){
        ArrayList<Field> fields=getFieldByClasss(o);
        WeakHashMap infoMap=new WeakHashMap();
        for(int i=0;i<fields.size();i++){
            if(null!= getFieldValue(fields.get(i),o)
                    &&!"serialVersionUID".equals(fields.get(i).getName())) {
                infoMap.put(fields.get(i).getName(), getFieldValue(fields.get(i), o));
            }
        }
        return infoMap;
    }

    /**
     * 获取对象的属性-值  map集合
     * @param o
     * @return
     */
    public static HashMap<String,Object> getFiledsInfoHash(Object o){
        ArrayList<Field> fields=getFieldByClasss(o);
        HashMap infoMap=new HashMap();
        for(int i=0;i<fields.size();i++){
            //去除null和序列化id
            if(null!= getFieldValue(fields.get(i),o)&&!"serialVersionUID".equals(fields.get(i).getName())) {
                infoMap.put(fields.get(i).getName(), getFieldValue(fields.get(i), o));
            }
        }
        return infoMap;
    }

    /**
     * 根据属性获取属性值
     *
     * @param field
     * @param object
     * @return
     */
    private static Object getFieldValue(Field field, Object object) {
        try {
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据属性名获取属性元素，包括各种安全范围和所有父类
     *
     * @param object
     * @return
     */
    private static ArrayList<Field> getFieldByClasss(Object object) {
        ArrayList<Field> fieldList = new ArrayList<>();
        Class<?> clazz = object.getClass();

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field[] fields= clazz.getDeclaredFields();
                for (Field fi:fields
                        ) {
                    fieldList.add(fi);
                }
            } catch (Exception e) {

            }
        }
        return fieldList;
    }
}
