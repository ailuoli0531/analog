package com.born.analog.net;

import com.born.analog.net.base.BaseRequestService;
import com.born.analog.net.base.BaseResponse;
import com.born.analog.net.base.SimpleCallBack;
import com.born.analog.net.module.LoginModule;
import com.born.analog.net.module.RegisterModule;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 注册
     *
     * @param phone
     * @param verify
     * @param psd
     */
    public static void register(String phone, String verify, String psd, SimpleCallBack<LoginModule> callBack) {
        RequestService service = BaseRequestService.getBaseService().create(RequestService.class);
        RegisterModule module = new RegisterModule();
        module.setAuthCode(verify);
        module.setPhoneNum(phone);
        module.setPwd(psd);
      /*  Map<String,Object> params = new HashMap<>();
        params.put("pwd",psd);
        params.put("authCode",verify);
        params.put("phoneNum",phone);*/
        Call<BaseResponse<LoginModule>> call = service.register(module);
        call.enqueue(callBack);
    }

    /**
     * 登录
     *
     * @param phone
     * @param psd
     * @param callBack
     */
    public static void login(String phone, String psd, SimpleCallBack<LoginModule> callBack) {
        RequestService service = BaseRequestService.getBaseService().create(RequestService.class);
        Map<String, String> params = new HashMap<>();
        params.put("phoneNum", phone);
        params.put("pwd", psd);
        Call<BaseResponse<LoginModule>> call = service.login(params);
        call.enqueue(callBack);
    }
}
