package tests;

import com.zhaoxi.edu.demo.JavaBean;
import com.zhaoxi.edu.demo.ServiceBean;
import com.zhaoxi.edu.demo.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    public static void main(String[] args) {
        // spring会把所有java对象转换Bean进行生命周期的管理
        // 2、先把需要管理这类转换为对应Bean进行统一管理（初始化spring容器）
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext1.xml"
                ,"applicationContext.xml");
        // 3、获取容器中创建的类的实例
        System.out.println(context.getBean("someService1"));
        // 3.1 这个方式获取对应实例
        SomeService someService = context.getBean("someService", SomeService.class);
        someService.doSomething();
        // 通过getBean(String name, Class<?> cls)获取
        JavaBean javaBean = context.getBean("javaBean", JavaBean.class);
        System.out.println(javaBean);
        // 4、如何配置和实现依赖注入 [基于setter方法]
        ServiceBean serviceBean = context.getBean("serviceBean", ServiceBean.class);
        serviceBean.helloService();
        System.out.println("============================================");
        // 4、基于构造函数完成依赖注入
        ServiceBean serviceBean_cto = context.getBean("serviceBean_cto", ServiceBean.class);
        serviceBean_cto.helloService();

        ///////////////////////////////// 验证Spring容器创建实例是否是单列的 /////////////////
        // 1、spring容器对需要管理类默认使用单列模式创建
        // 默认为singleton
        // 可以更改为多例
        System.out.println(context.getBean("someService1")==context.getBean("someService1"));
    }
}
