package com.born.analog.net;

import com.born.analog.net.base.BaseRequestService;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * created by born on 2019/1/7.
 */
public class RequestUtil {
    /**
     * 示例
     */
    public static void getTest(String s1, String s2, Callback callback) {
        RequestService service = BaseRequestService.getBaseService().create(RequestService.class);
        Call<JSONObject> call = service.getTest(s1, s2);
        call.enqueue(callback);
    }
}
