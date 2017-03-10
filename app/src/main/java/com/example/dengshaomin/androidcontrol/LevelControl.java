package com.example.dengshaomin.androidcontrol;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by dengshaomin on 2017/2/21.
 */
public class LevelControl extends GCLinearlayout {
    private ImageView lv_1, lv_2;

    public LevelControl(Context context) {
        this(context, null);
    }

    public LevelControl(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LevelControl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int setContentLayout() {
        return R.layout.level_control;
    }

    @Override
    public void initView() {
        lv_1 = (ImageView) findViewById(R.id.lv_1);
        lv_2 = (ImageView) findViewById(R.id.lv_2);
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
        if (data instanceof Integer) {
            setLevel(Integer.parseInt(String.valueOf(data)));
        }
    }

    private void setLevel(int level) {
        String lv = String.valueOf(level);
        String[] lvs = new String[lv.length()];
        for (int i = 0; i < lv.length(); i++) {
            lvs[i] = lv.substring(i, i + 1);
        }
        lv_2.setVisibility(lvs.length < 2 ? View.GONE : View.VISIBLE);
        lv_1.setBackgroundResource(getResources().getIdentifier("lv_" + lvs[0], "drawable", ((Activity) getmContext())
                .getBaseContext()
                .getPackageName()));
        if (lvs.length > 1) {
            lv_2.setBackgroundResource(getResources().getIdentifier("lv_" + lvs[1], "drawable", ((Activity) getmContext())
                    .getPackageName()));
        }
    }
}
