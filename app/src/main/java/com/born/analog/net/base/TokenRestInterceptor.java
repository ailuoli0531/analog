package com.born.analog.net.base;

import java.io.IOException;

import okhttp3.Interceptor;

/**
 * Created by WJ on 2017/2/23.
 */

public class TokenRestInterceptor implements Interceptor {
    private static final String TAG = "RestInterceptor:";

    private TokenRestInterceptor(){

    }

    private static TokenRestInterceptor instance;

    public static TokenRestInterceptor getInstance() {
        if (instance == null) {
            synchronized (TokenRestInterceptor.class) {
                instance = new TokenRestInterceptor();
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
//        LogUtil.e(TAG, "chain.request() " + chain.request().toString());
//        String authorization = appId + ":" + time;
//        String baseAuth = Base64.encode(authorization.getBytes());

        return chain.proceed(chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
//                .addHeader("Authorization", baseAuth)
//                .addHeader("Accept-Language",AppMgr.device_Language)
//                .addHeader("deviceType", String.valueOf(AppMgr.device_Type))
//                .addHeader("deviceId",AppMgr.deviceId)
//                .addHeader("deviceModel",AppMgr.device_Model)
//                .addHeader("deviceMAC",AppMgr.deviceMAC)
//                .addHeader("deviceIMEI",AppMgr.device_Imei)
//                .addHeader("deviceOS",AppMgr.device_OS)
//                .addHeader("ip",AppMgr.device_Ip)
//                .addHeader("token",AppMgr.getToken())
//                .addHeader("deviceChildType","0")
                .build());
    }
}