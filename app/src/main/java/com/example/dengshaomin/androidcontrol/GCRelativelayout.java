package com.example.dengshaomin.androidcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dengshaomin on 2016/10/21.
 */
public abstract class GCRelativelayout extends RelativeLayout implements GCUIInterface {
    public Context getmContext() {
        return mContext;
    }

    private Context mContext;
    private View rootView;

    @Override
    public View getRootView() {
        return rootView;
    }

    public GCRelativelayout(Context context) {
        this(context, null);
    }

    public GCRelativelayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GCRelativelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        setEvents();
        this.mContext = context;
        int layoutId = this.setContentLayout();
        if (layoutId == 0) {
            TextView tx = new TextView(mContext);
            tx.setText("setLayout first~~");
            this.addView(tx);
            return;
        }
        rootView = LayoutInflater.from(mContext).inflate(layoutId, this);
        if (rootView != null) {
            this.initView();
            this.initBundleData();
            this.getNetData();

        }
    }


    private void setEvents() {
        List<String> events = regeistEvent();
        if (regeistEvent() == null || events.size() == 0) {
            return;
        }
        //regeist here
    }

    @Override
    protected void onDetachedFromWindow() {
        //unrefeist
    }
}
