package com.test.ilvdo_http_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.alibaba.fastjson.TypeReference;
import com.ilvdo.ilvdo_http_android.callback.IOnSuccess;
import com.ilvdo.ilvdo_http_android.restclient.ConvertBean;
import com.ilvdo.ilvdo_http_android.restclient.RestClient;
import com.ilvdo.ilvdo_http_android.restclient.RestType;
import com.test.ilvdo_http_android.bean.CommonBean;
import com.test.ilvdo_http_android.bean.ResponseBean;

import java.util.List;

/**
 * Created by sjy on 2019/2/11
 * Describe
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    private void getData() {
         RestClient
                .builder()
                .type(RestType.GET)
                .params("page", "1")
                .params("count", "5")
                .url("")
                .convertType(new TypeReference<CommonBean<List<ResponseBean>>>(){})
                .success(new IOnSuccess<CommonBean<List<ResponseBean>>>() {
                    @Override
                    public void onSuccess(CommonBean<List<ResponseBean>> responseBean) {
                        ((TextView) findViewById(R.id.tv_content)).setText(responseBean.result.get(0).getAuthors());
                    }
                })
                .build();

    }
}
