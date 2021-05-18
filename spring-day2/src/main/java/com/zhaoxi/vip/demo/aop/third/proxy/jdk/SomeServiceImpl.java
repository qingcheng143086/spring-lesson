package com.zhaoxi.vip.demo.aop.third.proxy.jdk;

import com.zhaoxi.vip.demo.aop.old.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");
    }
    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther");
    }
}