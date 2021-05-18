package com.zhaoxi.vip.demo.demo1;

import com.zhaoxi.vip.demo.demo1.config.BeanConfig;
import com.zhaoxi.vip.demo.demo1.config.BeanConfig1;
import com.zhaoxi.vip.demo.demo1.dao.SomeDAOImpl;
import com.zhaoxi.vip.demo.demo1.service.SomeService;
import com.zhaoxi.vip.demo.demo1.service.SomeServiceImpl;
import com.zhaoxi.vip.demo.page.PageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 用来测试基于注解方式的容器对象Bean进行管理
 */
public class TestAnnotationContext {
    public static void main(String[] args) {
        // AnnotationConfigApplicationContext 注解配置的容器类
//        method1();
//        method2();
        method3();
//        method4();
    }


    private static void method1() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.zhaoxi.vip.demo.demo1","com.zhaoxi.vip.demo.page");
        SomeService someService = context.getBean("someService", SomeService.class);
        someService.doSomething();
    }

    private static void method2() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SomeDAOImpl.class, SomeServiceImpl.class, PageBean.class);
        /*String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/
        SomeService someService = context.getBean("someServiceImpl", SomeService.class);
        someService.doSomething();
    }

    // 基于配置类里面方法上面@Bean注解完成
    private static void method3() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        // 手动装配的实例bean名称就是方法名称
        SomeService someService = context.getBean("someService1", SomeService.class);
        someService.doSomething();
    }

    // 基于配置类上面的@Import注解完成
    private static void method4() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig1.class);
        // 生成bean名称就是装配类的全名称
        SomeService someService = context.getBean("com.zhaoxi.vip.demo.demo1.service.SomeServiceImpl", SomeService.class);
        someService.doSomething();
    }
}
