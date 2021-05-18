package com.zhaoxi.vip.demo.aop.third.proxy.jdk;

import com.zhaoxi.vip.demo.aop.second.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK动态代理
 * 缺点：只能代理实现了接口的类
 */
public class DemoProxy {
    // 因为动态代理不知道你代理具体类是什么，所以选择所有类父类Object作为代理类型
    private Object target;

    public DemoProxy(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(proxy.getClass());
                        ServiceTools.doLog(); // 写日志
                        Object result = method.invoke(target, args); // 反射形式调用目标类中真实的方法
                        ServiceTools.doTrans(); // 加入事务
                        return result;
                    }
                });
    }
}
