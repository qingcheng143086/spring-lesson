package com.zhaoxi.vip.demo.aop.four;

import com.zhaoxi.vip.demo.aop.old.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("context-aop.xml");
        SomeService someService = context.getBean("someService", SomeService.class);
        System.out.println(someService.getClass());
        //someService.doSome();
        //someService.doOther();
        String result = someService.doSomething("gerry");
        System.out.println("返回结果为===>" + result);
    }
}
