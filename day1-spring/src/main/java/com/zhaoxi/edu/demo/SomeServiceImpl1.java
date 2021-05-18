package com.zhaoxi.edu.demo;

public class SomeServiceImpl1 implements SomeService {

    public SomeServiceImpl1() {
        System.out.println("SomeServiceImpl1->instance");
    }

    @Override
    public void doSomething() {
        System.out.println("SomeServiceImpl1->doSomething");
    }
}
