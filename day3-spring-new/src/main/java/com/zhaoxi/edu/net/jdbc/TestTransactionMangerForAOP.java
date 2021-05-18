package com.zhaoxi.edu.net.jdbc;

import com.zhaoxi.edu.net.jdbc.service.OrderService;
import com.zhaoxi.edu.net.model.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * 测试Spring中对象事务使用AOP方式管理
 */
public class TestTransactionMangerForAOP {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("jdbc/spring-tx-xml.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        // 创建订单对象
        Order order = new Order();
        order.setOrderId(20101);
        order.setOrderMoney(new BigDecimal(443.2));
        order.setOrderAddress("重庆");
        orderService.addOrder(order);
    }
}
