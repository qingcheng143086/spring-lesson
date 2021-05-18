package com.zhaoxi.vip.demo.aop.four;

import com.zhaoxi.vip.demo.aop.old.SomeService;
import org.springframework.stereotype.Component;

@Component("someService")
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");
        throw new RuntimeException("故意抛出异常信息");
    }
    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther");
    }

    @Override
    public String doSomething(String name) {
        return "返回传入的name对应值为:"+name;
    }
}