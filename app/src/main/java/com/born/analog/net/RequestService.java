package com.born.analog.net;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
}
