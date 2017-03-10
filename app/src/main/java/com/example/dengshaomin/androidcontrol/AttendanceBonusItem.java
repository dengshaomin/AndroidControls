package com.example.dengshaomin.androidcontrol;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;


import com.example.dengshaomin.androidcontrol.sign.Reward;

import java.util.List;

/**
 * Created by dengshaomin on 2017/2/23.
 */
public class AttendanceBonusItem extends GCRelativelayout {
    private Reward reward;
    private TextView name, value;

    public AttendanceBonusItem(Context context) {
        super(context);
    }

    @Override
    public int setContentLayout() {
        return R.layout.attendance_bonus_item;
    }

    @Override
    public void initView() {
        name = (TextView) getRootView().findViewById(R.id.name);
        value = (TextView) getRootView().findViewById(R.id.value);
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
        if (data != null && data instanceof Reward) {
            reward = (Reward) data;
            name.setText(reward.getRewardName());
            if (reward.getRewardType() == 13) {
                drawRedIcon(name, getResources().getDrawable(R.drawable.dot_green));
                value.setText(Html.fromHtml("<b>+</b>" +
                        reward.getRewardNum()));
            } else if (reward.getRewardType() == 12) {
                drawRedIcon(name, getResources().getDrawable(R.drawable.dot_yellow));
                value.setText(Html.fromHtml("<b>+</b>" +
                        reward.getRewardNum()));
            } else if (reward.getRewardType() == -1) {
                setVisibility(GONE);
            } else {
                value.setText(reward.getRewardNum());
            }
        } else {
            setVisibility(GONE);
        }
    }

    private void drawRedIcon(TextView view, Drawable drawable) {
        if (drawable == null) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            drawable.setBounds(0, 0, 60, 60);
            view.setCompoundDrawables(drawable, null, null, null); //设置左图标
        }
    }
}
