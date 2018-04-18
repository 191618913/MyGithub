package com.gjl.Controller;

import com.gjl.model.textMessage;
import com.gjl.utils.CheckUtil;
import com.gjl.utils.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/11.
 */
@RestController
@RequestMapping(value = "/weixin")
public class WeiXinController {
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @ResponseBody
    public void validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        CheckUtil checkUtil = new CheckUtil();
        PrintWriter writer = response.getWriter();
        if (checkUtil.checkSignature(signature, timestamp, nonce, echostr)) {
            writer.print(echostr);
        }
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public void getMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Map<String, String> map = MessageUtil.xmlToMap(request);
        String tousername = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msgType = map.get("MsgType");
        String content = map.get("Content");
        String message = null;
        if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
            message = MessageUtil.initText(tousername, fromUserName, content);
            System.out.print(message);
        } else if (MessageUtil.MESSAGE_EVENT.equals(msgType)) {
            //回复一个图片
            String eventType = map.get("Event");
            if (MessageUtil.MESSAGE_CLICK.equals(eventType)) {
                String eventkey = map.get("EventKey");
                if (eventkey.equals("info")) {
                    message = MessageUtil.initNewsMessage(tousername, fromUserName);
                    System.out.print(message);
                }
            } else if (MessageUtil.MESSAGE_VIEW.equals(eventType)) {

            }
        }
        writer.print(message);
        writer.flush();
    }

}
