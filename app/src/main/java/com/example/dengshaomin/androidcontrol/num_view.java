package com.example.dengshaomin.androidcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by dengshaomin on 2017/2/21.
 */
public class num_view extends LinearLayout{
    private View rootView;
    public num_view(Context context) {
        this(context,null);
    }

    public num_view(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public num_view(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        rootView = LayoutInflater.from(context).inflate(R.layout.num_view,this);
    }
}
