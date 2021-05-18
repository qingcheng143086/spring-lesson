package com.zhaoxi.vip.demo.aop.third.proxy.cglib;

/**
 * 测试CGLIB代理
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        SomeServiceImpl proxy = (SomeServiceImpl) new CglibProxy(new SomeServiceImpl()).createProxy();
        proxy.doOther();
        proxy.doSome();
    }
}
