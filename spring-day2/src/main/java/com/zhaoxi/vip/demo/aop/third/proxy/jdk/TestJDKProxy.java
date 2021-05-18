package com.zhaoxi.vip.demo.aop.third.proxy.jdk;

import com.zhaoxi.vip.demo.aop.old.SomeService;

/**
 * 测试基于JDK动态代理来实现对其业务方法零入侵的增强
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        SomeService someService = new SomeServiceImpl();
        // 需要创建代理
        SomeService proxy = (SomeService) new DemoProxy(someService).createProxy();
        proxy.doSome();
        proxy.doOther();
    }
}
