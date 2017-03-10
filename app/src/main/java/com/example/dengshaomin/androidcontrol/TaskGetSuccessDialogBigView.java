package com.example.dengshaomin.androidcontrol;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.example.dengshaomin.androidcontrol.sign.Reward;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengshaomin on 2017/2/21.
 */
public class TaskGetSuccessDialogBigView extends GCLinearlayout {
    private List<Reward> rewards;
    private RelativeLayout true_view;
    private LinearLayout container;

    public TaskGetSuccessDialogBigView(Context context) {
        super(context);
    }

    public TaskGetSuccessDialogBigView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TaskGetSuccessDialogBigView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int setContentLayout() {
        return R.layout.task_get_successdialog_bigview;
    }

    @Override
    public void initView() {
        true_view = (RelativeLayout) findViewById(R.id.true_view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) true_view.getLayoutParams();
        layoutParams.width = DensityUtil.getScreenWidth((Activity) getmContext()) * 8 / 9;
        layoutParams.height = layoutParams.width;
        true_view.setLayoutParams(layoutParams);
        container = (LinearLayout) getRootView().findViewById(R.id.container);
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
        if (data == null) return;
        if (data instanceof ArrayList) {
            rewards = (List<Reward>) data;
            if (rewards != null && rewards.size() > 0) {
                for (Reward reward : rewards) {
                    AttendanceBonusItem attendanceBonusItem = new AttendanceBonusItem(getmContext());
                    attendanceBonusItem.setViewData(reward);
                    container.addView(attendanceBonusItem);
                }
            }
        }
    }
}
