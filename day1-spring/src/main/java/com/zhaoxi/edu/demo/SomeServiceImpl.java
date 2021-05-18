package com.zhaoxi.edu.demo;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl() {
        System.out.println("SomeServiceImpl->实例化");
    }

    @Override
    public void doSomething() {
        System.out.println("SomeServiceImpl->doSomething");
    }
}
