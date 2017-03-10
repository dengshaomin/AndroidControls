package com.example.dengshaomin.androidcontrol;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dengshaomin.androidcontrol.sign.*;

import java.util.List;

/**
 * Created by dengshaomin on 2017/2/21.
 */
public class SignSuccessDialogLCView extends GCLinearlayout {
    private SignObject signObject;
    private RelativeLayout true_view;
    private TextView get;
    private LevelControl level_control;
    private LinearLayout container;

    public SignSuccessDialogLCView(Context context) {
        super(context);
    }

    public SignSuccessDialogLCView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SignSuccessDialogLCView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int setContentLayout() {
        return R.layout.sign_success_dialog_lc_view;
    }

    @Override
    public void initView() {
        true_view = (RelativeLayout) findViewById(R.id.true_view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) true_view.getLayoutParams();
        layoutParams.width = DensityUtil.getScreenWidth((Activity) getmContext()) * 8 / 9;
        layoutParams.height = layoutParams.width * 745 / 593;
        true_view.setLayoutParams(layoutParams);
        level_control = (LevelControl) findViewById(R.id.level_control);
        container = (LinearLayout) getRootView().findViewById(R.id.container);
        get = (TextView) findViewById(R.id.get);
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
        if (data == null) return;
        if (data instanceof SignObject) {
            signObject = (SignObject) data;
            if (signObject.getReward() != null && signObject.getReward().size() > 0) {
                if (signObject.getData().getData() != null) {
                    level_control.setViewData(signObject.getData().getData().getLevel());
                }
                for (com.example.dengshaomin.androidcontrol.sign.Reward reward : signObject.getReward()) {
                    AttendanceBonusItem attendanceBonusItem = new AttendanceBonusItem(getmContext());
                    attendanceBonusItem.setViewData(reward);
                    container.addView(attendanceBonusItem);
                }
            }
        }
    }
}
