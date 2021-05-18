package com.zhaoxi.vip.demo.aop.four;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {
    // 定义切入点
    public static final String POINT_CUT = "execution(* com.zhaoxi.vip.demo.aop.four.SomeServiceImpl.do*(..))";
    // 切面中定义方法叫通知
    // 前置通知，后置通知，最后通知，异常通知，环绕通知
    // 使用以下注解标注通知类型：
    // @Before,@After，@AfterReturning,@AfterThrowing,@Around
    // 使用@Pointcut注解定义切入点
    // 切入点：就是通知需要放到具体类中哪个具体方法执行【拦截要被增强方法】
    @Before("execution(* com.zhaoxi.vip.demo.aop.four.SomeServiceImpl.do*(..)) && args(param)") // 前置通知，就是在目标方法执行之前调用
    public void doLog(JoinPoint jp, String param){
        System.out.println("拦截到的方法名称:"+jp.getSignature().getName());
        System.out.println("拦截到的具体目标类:"+jp.getTarget().getClass());
        System.out.println("拦截到参数列表为:"+ Arrays.toString(jp.getArgs()));
        System.out.println("拦截到参数列表为:"+ param);
        System.out.println("非业务功能，日志功能，在方法开始时输出日志");
    }

    @AfterReturning(value = POINT_CUT, returning = "re") // 返回通知，目标方法正确执行(执行没有出现异常)之后调用
    public void doTrans(Object re){
        System.out.println("非业务功能，在业务方法执行之后，加入事务,返回结果为："+re);
    }

    // 例外通知，异常通知，就是在执行目标方法的时候出现异常之后调用
    @AfterThrowing(value = POINT_CUT,throwing = "ex")
    public void doException(Exception ex) {
        System.out.println("非业务功能，在业务方法出现异常之后执行，具体异常信息为:"+ex.getMessage());
    }

    // 最终通知：不管前面执行是否正确，最后都需要执行该通知
    @After(POINT_CUT)
    public void doEnd() {
        System.out.println("非业务功能方法，不管前面执行是否正确，最后都需要执行该通知");
    }
    // 环绕通知：就是前置，后置，返回，最终通知归总
    @Around(POINT_CUT)
    public Object doAround(ProceedingJoinPoint pjp) {
        System.out.println("=============================================");
        System.out.println("就是能够表达式前置，后置，最终，例外通知的通知方法");
        Object result = null;
        try {
            System.out.println("前置通知");
            result = pjp.proceed(); // 放行调用目标类中的方法【反射调用】
            System.out.println("方法返回通知");
        } catch (Throwable e) {
            System.out.println("例外通知");
        } finally {
            System.out.println("最终通知");
        }

        return result;
    }
}
