package com.born.analog;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * created by born on 2019/1/8.
 * 查取用户信息常量
 */
public class AppMgr {
    public static Context appContext;
    public static void init(Context context){
        appContext = context;
    }

    private static SharedPreferences sharedPreferences;
    /*
     * 保存手机里面的名字
     */
    private static SharedPreferences.Editor editor;
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
