package com.zhaoxi.vip.demo.demo2;

import com.zhaoxi.vip.demo.demo2.config.ProConfig;
import com.zhaoxi.vip.demo.demo2.pros1.PropertiesDemo1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义属性文件的装配方式
 */
public class TestConfigProperties {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    /**
     * 基于XML文件方式装配属性文件的内容
     */
    private static void method1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context-properties.xml");
        PropertiesDemo1 pd = context.getBean("pd", PropertiesDemo1.class);
        pd.printUserDetail();
    }

    private static void method2() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ProConfig.class);
        PropertiesDemo1 pd = context.getBean("demo1", PropertiesDemo1.class);
        pd.printUserDetail();
    }
}
