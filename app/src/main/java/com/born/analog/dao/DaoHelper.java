package com.born.analog.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * created by born on 2018/10/30.
 * 数据库帮助类
 */
public class DaoHelper {
    //application context
    private static Context mContext;

    private static DaoHelper daoHelper;
    private static DaoSession daoSession;

    /**
     * 在application中初始化
     * @param context
     */
    public static void init(Context context){
        mContext = context;
        setupDatabase();
    }

    public static DaoHelper getInstance(){
        if(daoHelper==null){
            daoHelper = new DaoHelper();
        }
        return daoHelper;
    }

    /**
     * 配置数据库
     */
    private static void setupDatabase() {
        //创建数据库app.db"
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mContext, "analog.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public DaoSession getSession(){
        return daoSession;
    }

}
