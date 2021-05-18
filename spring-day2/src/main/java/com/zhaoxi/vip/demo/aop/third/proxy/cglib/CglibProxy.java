package com.zhaoxi.vip.demo.aop.third.proxy.cglib;

import com.zhaoxi.vip.demo.aop.second.ServiceTools;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class CglibProxy {
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        // 创建一个Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置改对象的父对象
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println(o.getClass());
                ServiceTools.doLog(); // 写日志
                Object result = method.invoke(target, objects); // 反射形式调用目标类中真实的方法
                ServiceTools.doTrans(); // 加入事务
                return result;
            }
        });

        return enhancer.create();
    }
}
