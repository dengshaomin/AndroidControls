package com.example.dengshaomin.androidcontrol;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by dengshaomin on 2016/11/9.
 */
public class GCFullDialog extends Dialog implements View.OnClickListener {
    //    private DialogActionLister dialogActionLister;
    private LinearLayout root_view;
    private Context context;

    public GCFullDialog(Context context) {
        this(context, R.style.game_dialog_style);
        this.context = context;
    }

    public GCFullDialog(Context context, int themeResId) {
        super(context, themeResId);
        setContentView(LayoutInflater.from(context).inflate(R.layout.gc_full_dialog, null), new ViewGroup.LayoutParams
                (DensityUtil.getScreenWidth(
                        (Activity) context),
                        DensityUtil.getScreenHeight((Activity) context)));
        root_view = (LinearLayout) findViewById(R.id.root_view);
    }


    public void addContentView(View view) {
        if (root_view != null) {
            root_view.removeAllViews();
            root_view.addView(view);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void show() {
        try {
            if (context != null && !((Activity) context).isFinishing() && !((Activity) context).isDestroyed()) {
                super.show();
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void dismiss() {
        try {
            if (context != null && !((Activity) context).isFinishing() && !((Activity) context).isDestroyed()) {
                super.dismiss();
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onClick(View v) {

    }


}
