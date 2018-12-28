package com.born.analog.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.born.analog.R;

/**
 * created by born on 2018/9/8.
 */
public class LoadingDialog extends Dialog implements DialogInterface.OnDismissListener {
    private ImageView imageView;
    private Animation rotate;
    private TextView loading_progress;
    public LoadingDialog(@NonNull Context context) {
        super(context,R.style.loading_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View loadView = LayoutInflater.from(getContext()).inflate(R.layout.loading_view,null,false);
        setContentView(loadView);

         imageView = loadView.findViewById(R.id.loading_img);
        loading_progress = loadView.findViewById(R.id.loading_progress);
        rotate = AnimationUtils.loadAnimation(getContext(),R.anim.loading_anim);
        imageView.setAnimation(rotate);

        imageView.setColorFilter(R.color.qing, PorterDuff.Mode.MULTIPLY);

        setOnDismissListener(this);

        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override
    public void show() {
        super.show();
        imageView.setAnimation(rotate);
    }

    public void showProgress(int pro){
        loading_progress.setText(pro+"%");
    }
    public void clearProgress(){
        loading_progress.setText("");
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        if(loading_progress!=null){
            loading_progress.setText("");
        }
    }
}
