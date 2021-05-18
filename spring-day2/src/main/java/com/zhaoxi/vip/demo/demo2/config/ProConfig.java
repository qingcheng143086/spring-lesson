package com.zhaoxi.vip.demo.demo2.config;

import com.zhaoxi.vip.demo.demo2.pros1.PropertiesDemo1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "user.properties", encoding = "UTF-8")
public class ProConfig {
    @Bean
    public PropertiesDemo1 demo1() {
        return new PropertiesDemo1();
    }
}
