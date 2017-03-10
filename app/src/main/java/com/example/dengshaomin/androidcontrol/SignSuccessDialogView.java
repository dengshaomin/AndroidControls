package com.example.dengshaomin.androidcontrol;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dengshaomin.androidcontrol.sign.AttendanceBonusItem;
import com.example.dengshaomin.androidcontrol.sign.Reward;
import com.example.dengshaomin.androidcontrol.sign.SignDataData;
import com.example.dengshaomin.androidcontrol.sign.SignObject;

import java.util.List;

/**
 * Created by dengshaomin on 2017/2/21.
 */
public class SignSuccessDialogView extends GCLinearlayout {
    private SignObject signObject;
    private RelativeLayout true_view;
    private LinearLayout container;
    private TextView sign_total;

    public SignSuccessDialogView(Context context) {
        super(context);
    }

    public SignSuccessDialogView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SignSuccessDialogView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int setContentLayout() {
        return R.layout.sign_success_dialog_view;
    }

    @Override
    public void initView() {
        true_view = (RelativeLayout) findViewById(R.id.true_view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) true_view.getLayoutParams();
        layoutParams.width = DensityUtil.getScreenWidth((Activity) getmContext()) * 6 / 7;
        layoutParams.height = layoutParams.width * 593 / 481;
        true_view.setLayoutParams(layoutParams);
        container = (LinearLayout) getRootView().findViewById(R.id.container);
        sign_total = (TextView) getRootView().findViewById(R.id.sign_total);
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
            if (signObject != null && signObject.getData() != null && signObject.getData().getData() != null) {
                SignDataData signDataData = signObject.getData().getData();
                if (signDataData.getNum().getExp() != 0) {
                    AttendanceBonusItem attendanceBonusItem = new AttendanceBonusItem(getmContext());
                    Reward reward = new Reward();
                    reward.setRewardNum(signDataData.getNum().getExp() + "");
                    reward.setRewardName("经验值");
                    reward.setRewardType(13);
                    attendanceBonusItem.setViewData(reward);
                    container.addView(attendanceBonusItem);
                }
                if (signDataData.getNum().getGold_coin() != 0) {
                    AttendanceBonusItem attendanceBonusItem = new AttendanceBonusItem(getmContext());
                    Reward reward = new Reward();
                    reward.setRewardNum(signDataData.getNum().getGold_coin() + "");
                    reward.setRewardName("金币");
                    reward.setRewardType(12);
                    attendanceBonusItem.setViewData(reward);
                    container.addView(attendanceBonusItem);
                }
                sign_total.setText(Html.fromHtml("已累计签到<b><font color = '#f17909'> " + signDataData.getSuccession
                        () +
                        " </font></b>天"));
            }
        }
    }
}
