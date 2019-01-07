package com.born.analog.net.base;

import com.born.analog.util.LogUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRequestService {
    private static final String TAG = "BaseRequestService:";
    private static HttpLoggingInterceptor httpLoggingInterceptor = null;

    static {
        httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtil.e(TAG, "[getRequestPBSService][log] message " + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    /**
     * 不带token的请求
     * @return
     */
    public static Retrofit getBaseService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(RestInterceptor.getInstance());
        builder.addInterceptor(httpLoggingInterceptor);
//        builder.sslSocketFactory(SelfSSLSocketFactory.getSSLSocketFactory(), new SSLCertificateValidation.NullX509TrustManager());
//        builder.hostnameVerifier(new SSLCertificateValidation.NullHostnameVerifier());
        builder.connectTimeout(60, TimeUnit.SECONDS);
        return new Retrofit.Builder().client(builder.build())
                .baseUrl(Config.BASE_HTTPS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 带token的请求
     * @return
     */
    public static Retrofit getTokenService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(TokenRestInterceptor.getInstance());
        builder.addInterceptor(httpLoggingInterceptor);
//        builder.sslSocketFactory(SelfSSLSocketFactory.getSSLSocketFactory(), new SSLCertificateValidation.NullX509TrustManager());
//        builder.hostnameVerifier(new SSLCertificateValidation.NullHostnameVerifier());
        builder.connectTimeout(60, TimeUnit.SECONDS);
        return new Retrofit.Builder().client(builder.build())
                .baseUrl(Config.BASE_HTTPS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
