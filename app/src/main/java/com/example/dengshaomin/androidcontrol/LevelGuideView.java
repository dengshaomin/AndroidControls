package com.example.dengshaomin.androidcontrol;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by dengshaomin on 2017/2/28.
 */
public class LevelGuideView extends GCLinearlayout {
    private View full_lay;

    public LevelGuideView(Context context) {
        super(context);
    }

    public LevelGuideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LevelGuideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int setContentLayout() {
        return R.layout.level_guide_view;
    }

    @Override
    public void initView() {
        full_lay = getRootView().findViewById(R.id.full_lay);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) full_lay.
                getLayoutParams();
        layoutParams.width = DensityUtil.getScreenWidth((Activity) getmContext()) * 7 / 9;
        full_lay.setLayoutParams(layoutParams);
    }

    @Override
    public void initBundleData() {

    }

    @Override
    public void getNetData() {

    }

    @Override
    public List<String> regeistEvent() {
        return null;
    }

    @Override
    public void EventComming(String indentify, Object data) {

    }

    @Override
    public void setViewData(Object data) {

    }
}
