package com.born.analog.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.born.analog.AppMgr;
import com.born.analog.R;
import com.born.analog.login.LoginActivity;
import com.born.analog.net.RequestUtil;
import com.born.analog.net.base.SimpleCallBack;
import com.born.analog.ui.BaseActivity;

import java.util.Objects;

/**
 * created by born on 2019/1/8.
 */
public class InfoDialog extends Dialog implements View.OnClickListener, TextView.OnEditorActionListener {

    private TextView text_name,text_phone,text_id,login_out;
    private AppCompatEditText edit_name;
    private BaseActivity activity;
    public InfoDialog(BaseActivity context) {
        super(context,R.style.loading_dialog);
        activity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View loadView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_info,null,false);
        setContentView(loadView);
        setCanceledOnTouchOutside(true);
        initView(loadView);
        initData();
    }

    private void initData() {
        text_name.setText("昵称："+AppMgr.getNickName());
        text_phone.setText("手机号："+AppMgr.getPhoneNum());
        text_id.setText("ID："+AppMgr.getAccountId());
    }

    private void initView(View view) {
        text_name = view.findViewById(R.id.text_name);
        text_phone = view.findViewById(R.id.text_phone);
        text_id = view.findViewById(R.id.text_id);
        login_out = view.findViewById(R.id.login_out);
        edit_name = view.findViewById(R.id.edit_name);

        login_out.setOnClickListener(this);
        text_name.setOnClickListener(this);
        edit_name.setOnEditorActionListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_out:
                loginOut();
                break;
            case R.id.text_name:
                editName();
                break;
        }
    }

    private void editName() {
        edit_name.setVisibility(View.VISIBLE);
        text_name.setVisibility(View.GONE);
        edit_name.setText(AppMgr.getNickName());
        edit_name.setSelection(Objects.requireNonNull(edit_name.getText()).length());
        edit_name.requestFocus();
        activity.showKeyboard(true);
    }

    private void loginOut() {
        AppMgr.clearUser();
        Intent intent = new Intent(activity,LoginActivity.class);
        activity.start(intent);
        activity.finish();
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if(i == EditorInfo.IME_ACTION_DONE){
            //用户按下确定
            if(TextUtils.isEmpty(edit_name.getText())){
                return true;
            }
            final String name = edit_name.getText().toString();
            RequestUtil.changeName(name, new SimpleCallBack() {
                @Override
                public void onSuccess(Object o) {
                    AppMgr.saveNickName(name);
                    edit_name.setVisibility(View.GONE);
                    text_name.setText(AppMgr.getNickName());
                    text_name.setVisibility(View.VISIBLE);
                    activity.showKeyboard(false);
                }

                @Override
                public void onFail() {

                }
            });
        }
        return true;
    }
}
