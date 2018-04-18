package com.gjl.utils;

import com.gjl.model.AccessToken;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * Created by Administrator on 2018/4/16.
 */
public class test {
    public static void main(String[] args) throws IOException {
        AccessToken accessToken=WeixinUtil.getAccessToken();
        System.out.print(accessToken.getToken()+"    "+accessToken.getExpires_in());
        String menu= JSONObject.fromObject(WeixinUtil.initMenu()).toString();
        System.out.print(menu);
        Integer result=WeixinUtil.createMenu(accessToken.getToken(),menu);
        if (result==0){
            System.out.print("菜单创建成功");
        }else {
            System.out.print(result);
        }

    }
}
