package com.zhaoxi.edu.demo.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试集合类型的装配
 */
public class TestFuheZp {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext-zp.xml");
        FuheInterface collections = context.getBean("collections", FuheInterface.class);
        System.out.println(collections.getLists());
        System.out.println(collections.getSets());
        System.out.println(collections.getMaps());
        System.out.println(collections.getPros());
    }
}
