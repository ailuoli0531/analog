package com.born.analog.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.born.analog.AppMgr;
import com.born.analog.R;
import com.born.analog.net.RequestUtil;
import com.born.analog.net.base.SimpleCallBack;
import com.born.analog.net.module.LoginModule;
import com.born.analog.ui.BaseActivity;
import com.born.analog.ui.MainActivity;

/**
 * created by born on 2019/1/8.
 * 注册
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout layout_verify, layout_login;
    private ImageView btn_login, btn_rigist;
    private AppCompatEditText edit_phone, edit_code, edit_psd;
    /**
     * 0 登录 1注册
     */
    private int LOGIN_MODE = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        btn_rigist = findViewById(R.id.btn_rigist);
        layout_verify = findViewById(R.id.layout_verify);
        layout_login = findViewById(R.id.layout_login);
        edit_phone = findViewById(R.id.edit_phone);
        edit_code = findViewById(R.id.edit_code);
        edit_psd = findViewById(R.id.edit_psd);
    }

    private void initListener() {
        btn_login.setOnClickListener(this);
        btn_rigist.setOnClickListener(this);
        layout_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                LOGIN_MODE = 0;
                layout_verify.setVisibility(View.GONE);
                btn_login.setVisibility(View.GONE);
                btn_rigist.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_rigist:
                LOGIN_MODE = 1;
                layout_verify.setVisibility(View.VISIBLE);
                btn_rigist.setVisibility(View.GONE);
                btn_login.setVisibility(View.VISIBLE);
                break;
            case R.id.layout_login:
                loginIn();
                break;
        }
    }

    private void loginIn() {
        if (TextUtils.isEmpty(edit_phone.getText())) {
            return;
        }
        if (TextUtils.isEmpty(edit_psd.getText())) {
            return;
        }

        if (LOGIN_MODE == 1 && TextUtils.isEmpty(edit_code.getText())) {
            return;
        }

        String phone = edit_phone.getText().toString().trim();
        String psd = edit_psd.getText().toString().trim();


        if (LOGIN_MODE == 0) {
            login(phone, psd);
        } else if (LOGIN_MODE == 1) {
            String verify = edit_code.getText().toString().trim();
            register(phone,psd,verify);
        }
    }

    /**
     * 注册
     * @param phone
     * @param psd
     * @param verify
     */
    private void register(String phone, String psd, String verify) {
        showDialog();
        RequestUtil.register(phone, verify, psd, new SimpleCallBack<LoginModule>() {
            @Override
            public void onSuccess(LoginModule loginModule) {
                hideDialog();
                AppMgr.initUser(loginModule);
                toMain();
            }

            @Override
            public void onFail() {
                hideDialog();
            }
        });
    }

    /**
     * 登录
     * @param phone
     * @param psd
     */
    private void login(String phone, String psd) {
        showDialog();
        RequestUtil.login(phone, psd, new SimpleCallBack<LoginModule>() {
            @Override
            public void onSuccess(LoginModule loginModule) {
                hideDialog();
                AppMgr.initUser(loginModule);
                toMain();
            }

            @Override
            public void onFail() {
                hideDialog();
            }
        });
    }


    private void toMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
