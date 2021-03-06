package com.born.analog.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.born.analog.ui.view.LoadingDialog;
import com.born.analog.ui.view.TargetBar;

/**
 * created by born on 2018/12/10.
 * 基类
 */
public class BaseActivity extends AppCompatActivity {
    private LoadingDialog dialog;
    private TargetBar targetBar;
    /**
     * 默认屏蔽物理返回键
     */
    public boolean NeedBack = false;
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


    public void showKeyboard(boolean isShow) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (isShow) {
            if (getCurrentFocus() == null) {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            } else {
                imm.showSoftInput(getCurrentFocus(), 0);
            }
        } else {
            if (getCurrentFocus() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    public void initBar(){
        targetBar = new TargetBar(this);
    }

    @Override
    public void onBackPressed() {
        if(NeedBack){
            super.onBackPressed();
        }
    }
}
