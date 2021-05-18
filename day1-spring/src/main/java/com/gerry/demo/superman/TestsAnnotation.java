package com.gerry.demo.superman;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试基于注解的IOC和DI
 */
public class TestsAnnotation {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
        // 默认名称为当前标记类的首字母小写
        ServiceBean serviceBean = context.getBean("serviceBean", ServiceBean.class);
        serviceBean.helloService();
    }
}
