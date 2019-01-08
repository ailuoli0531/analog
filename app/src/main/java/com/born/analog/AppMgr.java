package com.born.analog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.born.analog.net.module.LoginModule;

/**
 * created by born on 2019/1/8.
 * 查取用户信息常量
 */
public class AppMgr {
    public static Context appContext;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    public static void init(Context context){
        appContext = context;
        sharedPreferences = context.getSharedPreferences("analog",
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private static String accountId;
    private static String nickName;
    private static String phoneNum;
    private static String token;
    private static final String USER_ACCOUNT = "user_accountId";
    private static final String USER_NAME= "user_name";
    private static final String USER_PHONE= "user_phone";
    private static final String USER_TOKEN= "user_token";

    /**
     * 登录后保存用户信息
     * @param loginModule
     */
    public static void initUser(LoginModule loginModule){
        saveAccount(loginModule.getAccountId());
        saveNickName(loginModule.getNickName());
        savePhone(loginModule.getPhoneNum());
        saveToken(loginModule.getToken());
    }

    /**
     * 清空用户数据
     */
    public static void clearUser(){
        saveAccount("");
        saveNickName("");
        savePhone("");
        saveToken("");
    }

    private static void saveAccount(String accountId){
        AppMgr.accountId = accountId;
        save(USER_ACCOUNT,accountId);
    }
    public static void saveNickName(String nickName){
        AppMgr.nickName = nickName;
        save(USER_NAME,nickName);
    }
    private static void savePhone(String phoneNum){
        AppMgr.phoneNum=phoneNum;
        save(USER_PHONE,phoneNum);
    }
    private static void saveToken(String token){
        AppMgr.token = token;
        save(USER_TOKEN,token);
    }

    public static String getAccountId(){
        if(TextUtils.isEmpty(accountId)){
            accountId = (String) getSharedPreference(USER_ACCOUNT,null);
        }
        return accountId;
    }
    public static String getPhoneNum(){
        if(TextUtils.isEmpty(phoneNum)){
            phoneNum = (String) getSharedPreference(USER_PHONE,null);
        }
        return phoneNum;
    }

    public static String getToken(){
        if(TextUtils.isEmpty(token)){
            token = (String) getSharedPreference(USER_TOKEN,null);
        }
        return token;
    }

    public static String getNickName(){
        if(TextUtils.isEmpty(nickName)){
            nickName = (String) getSharedPreference(USER_NAME,null);
        }
        return nickName;
    }

    /**
     * 获取保存的数据
     */
    public static Object getSharedPreference(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        } else {
            return sharedPreferences.getString(key, null);
        }
    }

    /**
     * 存储
     */
    public static void save(String key, Object object) {
        if(object==null){
            return;
        }
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        editor.commit();
    }

}
