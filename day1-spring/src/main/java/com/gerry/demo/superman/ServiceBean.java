package com.gerry.demo.superman;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 在不创建SomeService接口对应实现类的情况下调用该实现类中对应方法
 */
@Component
public class ServiceBean {

    // 默认按照类型装配，所有在容器中找到2个相同类型的实例就会报错。
    // 为了解决该问题我需要指定名称装配
    /*@Autowired
    @Qualifier("someServiceImpl1")
    private SomeService service;*/

    @Resource(name = "s")
    // 默认按照名称装配，如果名称不存在，在按照类型装配，如果一旦指定名称，就只能按照名称装配。
    private SomeService s1;

    private String name;


    public ServiceBean() {
        System.out.println("ServiceBean中空构造函数");
    }

    public ServiceBean(SomeService service, String name) {
        System.out.println("ServiceBean中有参数构造函数");
        this.s1 = service;
        this.name = name;
    }

    public void helloService() {
        System.out.println("name="+name);
        s1.doSomething();
    }
}
