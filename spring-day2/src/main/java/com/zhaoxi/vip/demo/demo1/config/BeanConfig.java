package com.zhaoxi.vip.demo.demo1.config;

import com.zhaoxi.vip.demo.demo1.dao.SomeDAO;
import com.zhaoxi.vip.demo.demo1.dao.SomeDAOImpl;
import com.zhaoxi.vip.demo.demo1.service.SomeService;
import com.zhaoxi.vip.demo.demo1.service.SomeServiceImpl;
import com.zhaoxi.vip.demo.page.PageBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 代表该类是一个配置类
public class BeanConfig {
    // 使用@Bean注解完成手动装配对象
    @Bean
    public SomeDAO someDAO() {
        return new SomeDAOImpl();
    }

    @Bean
    public SomeService someService1() {
        return new SomeServiceImpl();
    }

    @Bean
    public PageBean pageBean() {
        return new PageBean();
    }
}
