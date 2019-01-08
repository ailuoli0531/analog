package com.born.analog.net.base;

import android.text.TextUtils;

import com.born.analog.util.ToastUtil;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * created by born on 2018/9/11.
 * 对retrofit回掉做一层封装，直接拿到对象
 */
public abstract class SimpleCallBack<T> implements Callback<BaseResponse<T>> {
    private static Gson gson = new Gson();
    private boolean isShowToast = true;

    public SimpleCallBack() {
    }

    public SimpleCallBack(boolean isShowToast) {
        this.isShowToast = isShowToast;
    }
    @Override
    public void onResponse(Call call, Response response) {
        if(response!=null && response.isSuccessful()){
            BaseResponse<T> baseResponse = (BaseResponse<T>) response.body();
            if(NetCode.CheckCode(baseResponse.getCode())){
                onSuccess(baseResponse.getT());
            }else{
                if(isShowToast && baseResponse.getCode()!=275 ){
                    ToastUtil.show(baseResponse.getMsg());
                }
                onFailCode(baseResponse.getCode());
                onFail();
            }
        }else if(response!=null && response.errorBody()!=null){
            BaseResponse error = null;
            try {
                error = gson.fromJson(response.errorBody().string(),BaseResponse.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (isShowToast) {
                if(error != null && !TextUtils.isEmpty(error.getMsg())){
                    onFailCode(error.getCode());
                }else{
                    ToastUtil.showFail();
                }
            }

            onFail();
        } else{
            if(isShowToast)
                ToastUtil.showFail();
            onFail();
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        onFail();
    }

    public abstract void onSuccess(T t);
    public abstract void onFail();

    public void onFailCode(int code) {

    }
}
