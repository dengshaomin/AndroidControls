package com.example.dengshaomin.androidcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.dengshaomin.androidcontrol.sign.Reward;

import java.util.List;

/**
 * Created by dengshaomin on 2017/2/28.
 */
public class TaskCenterBonusItem extends GCRelativelayout {
    private TextView level_up, get;
    private List<Reward> rewards;

    public TaskCenterBonusItem(Context context) {
        super(context);
    }

    public TaskCenterBonusItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TaskCenterBonusItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int setContentLayout() {
        return R.layout.taskcenter_bonusitem;
    }

    @Override
    public void initView() {
        level_up = (TextView) getRootView().findViewById(R.id.level_up);
        get = (TextView) getRootView().findViewById(R.id.get);
        get.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
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
        if (data == null || !(data instanceof Reward)) {
            setVisibility(GONE);
            return;
        }
        rewards = (List<Reward>) data;

    }
}
