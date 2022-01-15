package com.atguigu.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 @author：ZhouYao
 @create：2022-01-13 17:13
 */

@Configuration
public class MyDataSourceConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {

        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }


}
