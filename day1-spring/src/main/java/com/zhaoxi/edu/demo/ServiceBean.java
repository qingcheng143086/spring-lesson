package com.zhaoxi.edu.demo;

/**
 * 在不创建SomeService接口对应实现类的情况下调用该实现类中对应方法
 */
public class ServiceBean {
    private SomeService service;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public ServiceBean() {
        System.out.println("ServiceBean中空构造函数");
    }

    public ServiceBean(SomeService service, String name) {
        System.out.println("ServiceBean中有参数构造函数");
        this.service = service;
        this.name = name;
    }
    /**
     * 提供属性setter方法
     * @param service
     */
    public void setService(SomeService service) {
        this.service = service;
    }

    public void helloService() {
        System.out.println("name="+name);
        service.doSomething();
    }
}
