package com.example.dengshaomin.androidcontrol;

import java.util.List;

/**
 * Created by dengshaomin on 2016/10/21.
 */
public interface GCUIInterface {
    public int setContentLayout();

    public void initView();

    public void initBundleData();

    public void getNetData();

    public List<String> regeistEvent();

    public void EventComming(String indentify, Object data);

    public void setViewData(Object data);
}
