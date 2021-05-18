package com.zhaoxi.vip.demo.aop.second;

import com.zhaoxi.vip.demo.aop.old.SomeService;

public class SomeServiceImpl2 implements SomeService {
    @Override
    public void doSome() {
        ServiceTools.doLog();
        System.out.println("执行业务方法doSome");
        ServiceTools.doTrans();
    }
    @Override
    public void doOther() {
        ServiceTools.doLog();
        System.out.println("执行业务方法doOther");
        ServiceTools.doTrans();
    }
}