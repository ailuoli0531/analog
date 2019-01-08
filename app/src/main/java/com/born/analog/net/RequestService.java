package com.born.analog.net;

import com.born.analog.net.base.BaseResponse;
import com.born.analog.net.module.LoginModule;
import com.born.analog.net.module.RegisterModule;

import org.json.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * created by born on 2019/1/7.
 */
public interface RequestService {
    /**
     * 示例
     * @param auth
     * @param body
     * @return
     */
    @POST("/fc1/getFCList/{auth}")
    Call<JSONObject> getTest(@Path("auth") String auth, @Body String body);

    /**
     * 注册
     * @param params
     * @return
     */
    @POST("/user/register")
    Call<BaseResponse<LoginModule>> register(@Body RegisterModule params);

    /**
     * 登录
     * @param params
     * @return
     */
    @POST("/user/login")
    Call<BaseResponse<LoginModule>> login(@Body Map<String,String> params);
}
