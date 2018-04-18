package com.gjl.utils;

import com.gjl.menu.Button;
import com.gjl.menu.ClickButton;
import com.gjl.menu.MenuVo;
import com.gjl.menu.ViewButton;
import com.gjl.model.AccessToken;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2018/4/16.
 */
public class WeixinUtil {
    private static final String APPID = "wx39ebc630175209ae";
    private static final String AppSecret = "4f6bd5b9a99cf8b75efbac43b49e447d";
    private static final String Get_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static final String Creat_menu_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static JSONObject dogetStr(String url) throws IOException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;
        HttpResponse response = defaultHttpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.fromObject(result);
        }
        return jsonObject;

    }

    public static JSONObject doPostStr(String url, String outStr) throws IOException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        httpPost.setEntity(new StringEntity(outStr, "UTF-8"));
        HttpResponse response = defaultHttpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        jsonObject = JSONObject.fromObject(result);
        return jsonObject;
    }

    public static AccessToken getAccessToken() throws IOException {
        AccessToken token = new AccessToken();
        String result = Get_token_url.replace("APPID", APPID).replace("APPSECRET", AppSecret);
        JSONObject jsonObject = dogetStr(result);
        if (jsonObject != null) {
            token.setToken(jsonObject.getString("access_token"));
            token.setExpires_in(jsonObject.getInt("expires_in"));
        }
        return token;
    }

    public static MenuVo initMenu() {
        MenuVo menuVo = new MenuVo();
        ViewButton viewButton1 = new ViewButton();
        viewButton1.setUrl("http://www.baidu.com");
        viewButton1.setName("成绩查询");
        viewButton1.setType("view");

        ViewButton viewButton2 = new ViewButton();
        viewButton2.setType("view");
        viewButton2.setName("课表查询");
        viewButton2.setUrl("http://www.baidu.com");

        ViewButton viewButton3 = new ViewButton();
        viewButton3.setName("请假申请");
        viewButton3.setUrl("http://www.baidu.com");
        viewButton3.setType("view");

        ViewButton viewButton4 = new ViewButton();
        viewButton4.setType("view");
        viewButton4.setName("考试查询");
        viewButton4.setUrl("http://www.baidu.com");

        ViewButton viewButton5 = new ViewButton();
        viewButton5.setUrl("http://www.baidu.com");
        viewButton5.setName("问题提问");
        viewButton5.setType("view");

        ViewButton viewButton6 = new ViewButton();
        viewButton6.setType("view");
        viewButton6.setName("考勤");
        viewButton6.setUrl("http://www.baidu.com");

        ViewButton viewButton7 = new ViewButton();
        viewButton7.setUrl("http://www.baidu.com");
        viewButton7.setName("问题列表");
        viewButton7.setType("view");

        ViewButton viewButton8 = new ViewButton();
        viewButton8.setType("view");
        viewButton8.setUrl("http://www.baidu.com");
        viewButton8.setName("请假审批列表");

        ViewButton viewButton9 = new ViewButton();
        viewButton9.setName("账号绑定");
        viewButton9.setUrl("http://www.baidu.com");
        viewButton9.setType("view");

        ClickButton clickButton1 = new ClickButton();
        clickButton1.setKey("year");
        clickButton1.setName("学校日历");
        clickButton1.setType("click");

        ClickButton clickButton2 = new ClickButton();
        clickButton2.setType("click");
        clickButton2.setName("教务通知");
        clickButton2.setKey("info");

        Button button1 = new Button();
        button1.setName("学生模块");
        button1.setSub_button(new Button[]{ viewButton1,viewButton2,viewButton3,viewButton4,viewButton5});

        Button button2 = new Button();
        button2.setName("教师模块");
        button2.setSub_button(new Button[]{viewButton6, viewButton7, viewButton8});

        Button button3 = new Button();
        button3.setName("公共模块");
        button3.setSub_button(new Button[]{viewButton9,clickButton1,clickButton2});

        menuVo.setButton(new Button[]{ button1,button2,button3});
        return menuVo;

    }

    public static Integer createMenu(String token, String menu) throws IOException {
        String url = Creat_menu_url.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = doPostStr(url, menu);
        Integer result = 0;
        if (jsonObject != null) {
            result = jsonObject.getInt("errcode");
        }
        return result;


    }
}
