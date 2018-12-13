package com.born.analog;

import android.app.Application;

import com.born.analog.dao.DaoHelper;

/**
 * created by born on 2018/12/13.
 */
public class AnaLogApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
        DaoHelper.init(this);
    }
}
