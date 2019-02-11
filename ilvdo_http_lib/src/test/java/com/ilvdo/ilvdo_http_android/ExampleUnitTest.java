package com.ilvdo.ilvdo_http_android;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private String res="{\n" +
            "        \"UserInfo\": {\n" +
            "          \"MemberGuid\": \"d9353152-e273-49be-9337-14015d33fbd6\",\n" +
            "          \"MemberThirdId\": \"p18050210265326\",\n" +
            "          \"MemberName\": \"徐浩杰02\",\n" +
            "          \"MemberRealName\": \"真名测试\",\n" +
            "          \"MemberSex\": \"0858fad1-30d9-4abe-9d72-867f907bb8ad\",\n" +
            "          \"MemberProvince\": \"江苏省\",\n" +
            "          \"MemberCity\": \"无锡市\",\n" +
            "          \"MemberArea\": \"惠山区\",\n" +
            "          \"MemberMoblie\": \"18862281863\",\n" +
            "          \"MemberHeadPic\": \"\",\n" +
            "          \"MemberPersonalPic\": \"\",\n" +
            "          \"MemberAge\": \"0\",\n" +
            "          \"CustomerType\": \"1\"\n" +
            "        },\n" +
            "        \"TelephoneMachineID\": \"FWZS1902001\"\n" +
            "      }";
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testA(){
        TestBean<UserInfo> testBean=JSON.parseObject(res,new TypeReference<TestBean<UserInfo>>(){});
    }
}