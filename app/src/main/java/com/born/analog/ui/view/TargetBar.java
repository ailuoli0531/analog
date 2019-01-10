package com.born.analog.ui.view;

import android.view.View;
import android.widget.ImageView;

import com.born.analog.R;
import com.born.analog.ui.BaseActivity;

/**
 * created by born on 2019/1/10.
 */
public class TargetBar implements View.OnClickListener {
    private BaseActivity mContext;
    private ImageView back_img;
    public TargetBar(BaseActivity activity){
        mContext = activity;
        initView();
    }

    private void initView() {
        back_img = mContext.findViewById(R.id.back_img);
        back_img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_img:
                mContext.finish();
                break;
        }
    }
}
