package com.gjl.utils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.gjl.model.News;
import com.gjl.model.NewsMessage;
import com.gjl.model.textMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

import java.util.*;

/**
 * Created by Administrator on 2018/4/11.
 * xml 消息转换
 */
public class MessageUtil {
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";
    public static final String MESSAGE_NEWS = "news";


    /**
     * xml转为map集合
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        InputStream inputStream = request.getInputStream();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> list = root.elements();
        for (Element element : list) {
            map.put(element.getName(), element.getText());
        }
        return map;
    }

    /**
     * 将对象转换成为xml
     */
    public static String objectToXml(textMessage textMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", textMessage.getClass());
        String result = xStream.toXML(textMessage);
        return result;

    }

    /**
     * 图文消息转换
     */

    public static String newsToXml(NewsMessage newsMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new News().getClass());
        return xStream.toXML(newsMessage);


    }

    public static String initNewsMessage(String ToUserName, String FromUserName) {
        String message = null;
        List<News> list = new ArrayList<>();
        NewsMessage newsMessage = new NewsMessage();
        News news = new News();
        Wrapper<News> wrapper = new EntityWrapper<>();
        wrapper.groupBy("j_time");
        List<News> list1 = newsMapper.selectList(wrapper);
        list.add(list1.get(0));
        newsMessage.setFromUserName(ToUserName);
        newsMessage.setToUserName(FromUserName);
        newsMessage.setArticleCount(list.size());
        newsMessage.setArticles(list);
        newsMessage.setMsgType(MessageUtil.MESSAGE_NEWS);
        newsMessage.setCreateTime(new Date().getTime());
        message = MessageUtil.newsToXml(newsMessage);
        return message;

    }


    public static String initText(String tousername, String fromUserName, String content) {
        textMessage text = new textMessage();
        text.setFromUserName(tousername);
        text.setToUserName(fromUserName);
        text.setContent("您发送的消息为:" + content);
        text.setMsgType("text");
        text.setCreateTime(new Date().getTime());
        return MessageUtil.objectToXml(text);

    }
}
