package com.born.analog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * created by born on 2018/12/10.
 * 基类
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * 跳转
     * @param intent
     */
    public void start(Intent intent) {
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    /**
     * 回传值跳转
     * @param intent
     * @param request
     */
    public void startForResult(Intent intent,int request){
        startActivityForResult(intent,request);
        overridePendingTransition(0,0);
    }
}
