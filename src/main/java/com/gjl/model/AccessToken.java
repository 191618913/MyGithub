package com.gjl.model;

/**
 * Created by Administrator on 2018/4/16.
 */
public class AccessToken {
         private  String token;
         private Integer expires_in;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
