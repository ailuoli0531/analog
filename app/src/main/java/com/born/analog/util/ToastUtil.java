package com.born.analog.util;

import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

import com.born.analog.AppMgr;
import com.born.analog.R;


/**
 * created by born on 2018/9/6.
 * 居中的toast
 */
public class ToastUtil {
    private static Toast toast;
    public static void show(String tip){
        try{
            if(toast!=null){
                toast.setText(tip);
            }else {
                toast = Toast.makeText(AppMgr.appContext, tip, Toast.LENGTH_SHORT);
            }
            toast.show();
        }catch (Exception e){
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(AppMgr.appContext, tip, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }

    }

    public static void show(int tipId){
        try {
            if(toast!=null){
                toast.setText(tipId);
            }else{
                toast = Toast.makeText(AppMgr.appContext,tipId,Toast.LENGTH_SHORT);
            }
            toast.show();
        }catch (Exception e){
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(AppMgr.appContext, tipId, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }

    }

    public static void showFail(){
        show(AppMgr.appContext.getResources().getString(R.string.toast_fail));
    }

}
