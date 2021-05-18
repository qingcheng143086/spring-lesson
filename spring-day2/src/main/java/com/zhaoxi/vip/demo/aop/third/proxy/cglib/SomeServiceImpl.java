package com.zhaoxi.vip.demo.aop.third.proxy.cglib;

public class SomeServiceImpl {
    public void doSome() {
        System.out.println("执行业务方法doSome");
    }
    public void doOther() {
        System.out.println("执行业务方法doOther");
    }
}