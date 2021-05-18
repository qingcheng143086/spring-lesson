package com.zhaoxi.vip.demo.demo1.config;

import com.zhaoxi.vip.demo.demo1.dao.SomeDAOImpl;
import com.zhaoxi.vip.demo.demo1.service.SomeServiceImpl;
import com.zhaoxi.vip.demo.page.PageBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 代表该类是一个配置类
@Import({SomeServiceImpl.class, PageBean.class, SomeDAOImpl.class})
public class BeanConfig1 {

}
