package com.born.analog.net.module;

/**
 * created by born on 2019/1/8.
 */
public class LoginModule {

    /**
     * accountId : 08d49461e7af4a85b9eff14e17bb127e
     * nickName : 玩家
     * phoneNum : 15001190531
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50SWQiOiIwOGQ0OTQ2MWU3YWY0YTg1YjllZmYxNGUxN2JiMTI3ZSIsImlzcyI6Im1vbmlxaV91c2VyIiwiZXhwIjoxNTQ5NTIyMDU1LCJ0cyI6IjE1NDY5MzAwNTUifQ.XartXuz4ZBw-wbmDlrxKUCl0Fl9suwLhDMT9Eq-7zBQ
     */

    private String accountId;
    private String nickName;
    private String phoneNum;
    private String token;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
