package com.mikk.mikk_ec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mikk.mikk.delegates.MikkDelegate;
import com.mikk.mikk.net.RestClient;
import com.mikk.mikk.net.callback.IError;
import com.mikk.mikk.net.callback.IFailure;
import com.mikk.mikk.net.callback.ISuccess;

/**
 * Created by Mikk on 2017/9/19.
 */

public class ExampleDelegate extends MikkDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(),response,Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
