package com.born.analog.net.module;

/**
 * created by born on 2019/1/8.
 */
public class RegisterModule {
    private String pwd;
    private String authCode;
    private String phoneNum;

    public RegisterModule() {
    }

    public RegisterModule(String pwd, String authCode, String phoneNum) {
        this.pwd = pwd;
        this.authCode = authCode;
        this.phoneNum = phoneNum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
