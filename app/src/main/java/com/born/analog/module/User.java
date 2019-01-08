package com.born.analog.module;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * created by born on 2019/1/8.
 */
@Entity
public class User {
    private String account;
    private String phone;
    private String name;
    private String avator;
    private String token;
    @Generated(hash = 595421257)
    public User(String account, String phone, String name, String avator,
            String token) {
        this.account = account;
        this.phone = phone;
        this.name = name;
        this.avator = avator;
        this.token = token;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAvator() {
        return this.avator;
    }
    public void setAvator(String avator) {
        this.avator = avator;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
