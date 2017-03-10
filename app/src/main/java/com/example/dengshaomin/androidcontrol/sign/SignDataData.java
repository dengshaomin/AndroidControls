package com.example.dengshaomin.androidcontrol.sign;

/**
 * Created by dengshaomin on 2017/2/22.
 */
public class SignDataData {
    private int status;
    private String info;
    private int upgrade;
    private int level;
    private int succession;
    private int succession_reward_gold_coin;
    private Num num;

    public Num getNum() {
        return num;
    }

    public void setNum(Num num) {
        this.num = num;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(int upgrade) {
        this.upgrade = upgrade;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSuccession() {
        return succession;
    }

    public void setSuccession(int succession) {
        this.succession = succession;
    }

    public int getSuccession_reward_gold_coin() {
        return succession_reward_gold_coin;
    }

    public void setSuccession_reward_gold_coin(int succession_reward_gold_coin) {
        this.succession_reward_gold_coin = succession_reward_gold_coin;
    }
}
