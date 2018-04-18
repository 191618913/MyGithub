package com.gjl.config;

/**
 * Created by Administrator on 2017/12/21.
 */
import com.alibaba.druid.pool.DruidDataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 */
@Configuration
@MapperScan(basePackages = {"com.gjl.mapper"})
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;

    /**
     * guns的数据源
     */
    private DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource singleDatasource() {
        return dataSource();
    }



    /**
     * mybatis-plus分页插件
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }

}