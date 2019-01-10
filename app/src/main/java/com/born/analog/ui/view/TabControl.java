package com.born.analog.ui.view;

import android.view.View;
import android.widget.LinearLayout;

import com.born.analog.R;
import com.born.analog.ui.BaseActivity;
import com.born.analog.util.ToastUtil;

/**
 * created by born on 2019/1/10.
 */
public class TabControl implements View.OnClickListener {
    private BaseActivity activity;
    private LinearLayout exit_layout,paihang_layout,info_layout;
    public TabControl(BaseActivity context){
        activity = context;

        initView();
    }

    private void initView() {
        exit_layout = activity.findViewById(R.id.exit_layout);
        paihang_layout = activity.findViewById(R.id.paihang_layout);
        info_layout = activity.findViewById(R.id.info_layout);
        exit_layout.setOnClickListener(this);
        paihang_layout.setOnClickListener(this);
        info_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.exit_layout:
                activity.finish();
                break;
            case R.id.paihang_layout:
                ToastUtil.show("敬请期待");
                break;
            case R.id.info_layout:
                new InfoDialog(activity).show();
                break;
        }
    }
}
