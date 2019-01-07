package com.born.analog;

import android.app.Application;
import android.graphics.Typeface;

import com.born.analog.dao.DaoHelper;
import com.born.analog.util.LogUtil;

import java.lang.reflect.Field;

/**
 * created by born on 2018/12/13.
 */
public class AnaLogApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
        DaoHelper.init(this);
        setTypeFace();
    }

    /**
     * 设置全局字体
     */
    public void setTypeFace(){
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/GirlType.ttf");
        try {
            Field field = Typeface.class.getDeclaredField("MONOSPACE");
            field.setAccessible(true);
            field.set(null, typeface);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
