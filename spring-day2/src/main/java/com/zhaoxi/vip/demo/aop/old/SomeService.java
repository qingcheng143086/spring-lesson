package com.zhaoxi.vip.demo.aop.old;

public interface SomeService {
    void doSome();
    // JDK1.8版本及以上可以在接口中定义实现的方法，但是必须在方法前面加上default关键字
    default String doSomething(String name) {
        return null;
    }

    void doOther();
}
