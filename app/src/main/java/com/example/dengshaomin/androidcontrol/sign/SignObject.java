package com.example.dengshaomin.androidcontrol.sign;

import java.util.List;

/**
 * Created by dengshaomin on 2017/2/22.
 */
public class SignObject {
    private String code;
    private SignData data;
    private List<Reward> reward;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SignData getData() {
        return data;
    }

    public void setData(SignData data) {
        this.data = data;
    }

    public List<Reward> getReward() {
        return reward;
    }

    public void setReward(List<Reward> reward) {
        this.reward = reward;
    }
}
