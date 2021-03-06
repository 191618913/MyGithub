package com.gjl.config;

/**
 * Created by Administrator on 2017/12/21.
 */

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class FastjsonConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
//        FastJsonConfig config = new FastJsonConfig();
//
//        config.setCharset(Charset.forName("UTF-8"));
//        converter.setFastJsonConfig(config);
        converters.add(converter);
    }
}