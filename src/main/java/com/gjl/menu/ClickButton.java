package com.gjl.menu;

/**
 * Created by Administrator on 2018/4/16.
 */
public class ClickButton extends Button {
    private String key;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
