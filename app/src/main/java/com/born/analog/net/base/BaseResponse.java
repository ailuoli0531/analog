package com.born.analog.net.base;

/**
 * created by born on 2018/9/11.
 */
public class BaseResponse<T> {

    /**
     * code : 0
     */

    private int code;
    private String msg;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getT() {
        return data;
    }

    public void setT(T data) {
        this.data = data;
    }
}
