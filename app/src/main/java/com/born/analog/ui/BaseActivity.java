package com.born.analog.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.born.analog.ui.view.LoadingDialog;

/**
 * created by born on 2018/12/10.
 * 基类
 */
public class BaseActivity extends AppCompatActivity {
    private LoadingDialog dialog;
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

    /**
     * 显示加载中
     */
    public void showDialog(){
        if(dialog==null){
            dialog = new LoadingDialog(this);
        }
        if(!dialog.isShowing()){
            dialog.show();
        }
    }
    public void hideDialog(){
        if(dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
            dialog.clearProgress();
        }
    }
}
