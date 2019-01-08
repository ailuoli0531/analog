package com.born.analog.net.base;

import com.born.analog.util.LogUtil;

import java.io.IOException;
import okhttp3.Interceptor;

/**
 * Created by WJ on 2017/2/23.
 */

public class RestInterceptor implements Interceptor {
    private static final String TAG = "RestInterceptor:";

    private RestInterceptor(){

    }

    private static RestInterceptor instance;

    public static RestInterceptor getInstance() {
        if (instance == null) {
            synchronized (RestInterceptor.class) {
                instance = new RestInterceptor();
            }
        }
        return instance;
    }

    private String appId;
    private String time;

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        LogUtil.e(TAG, "chain.request() " + chain.request().toString());
//        String authorization = appId + ":" + time;
//        String baseAuth = Base64.encode(authorization.getBytes());

        return chain.proceed(chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .build());
    }
}