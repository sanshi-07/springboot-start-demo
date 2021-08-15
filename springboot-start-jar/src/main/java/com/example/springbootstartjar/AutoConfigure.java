package com.example.springbootstartjar;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Service.class)
@EnableConfigurationProperties(Properties.class)
@Slf4j
public class AutoConfigure {

    @Autowired
    private Properties properties;

    @Bean
    @ConditionalOnMissingBean(Service.class)
    // @ConditionalOnProperty(prefix = "com.example",value = "enabled", havingValue = "true")
    Service kiteService(){
        System.out.println("开始配置了，这里将注入一个bean");
        return new Service(properties);
    }
}