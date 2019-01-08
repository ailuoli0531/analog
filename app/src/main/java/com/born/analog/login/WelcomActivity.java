package com.born.analog.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.born.analog.AnaLog;
import com.born.analog.R;
import com.born.analog.manager.DbUserManager;
import com.born.analog.module.User;
import com.born.analog.ui.BaseActivity;
import com.born.analog.ui.MainActivity;

/**
 * created by born on 2019/1/8.
 * 欢迎页
 */
public class WelcomActivity extends BaseActivity {
    private LinearLayout layout_wait;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        layout_wait = findViewById(R.id.layout_wait);

        AnaLog.init(this);

        //是否登录
        User user = DbUserManager.getInstance().getUser();
        if(user==null){
            layout_wait.postDelayed(loginRun,1000);
        }else{
            layout_wait.postDelayed(mainRun,1000);
        }
    }

    private Runnable loginRun = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(WelcomActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

    private Runnable mainRun = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(WelcomActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
