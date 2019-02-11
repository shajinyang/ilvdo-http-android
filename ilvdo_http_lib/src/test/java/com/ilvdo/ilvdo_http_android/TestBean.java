package com.ilvdo.ilvdo_http_android;

/**
 * Created by sjy on 2019/2/11
 * Describe
 */
public class TestBean<T> {
    public T UserInfo;
    public String TelephoneMachineID;

    public T getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(T userInfo) {
        this.UserInfo = userInfo;
    }

    public String getTelephoneMachineID() {
        return TelephoneMachineID;
    }
    public void setTelephoneMachineID(String telephoneMachineID) {
        TelephoneMachineID = telephoneMachineID;
    }
}
