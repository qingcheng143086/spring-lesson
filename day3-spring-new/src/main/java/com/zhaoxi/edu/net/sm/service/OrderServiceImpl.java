package com.zhaoxi.edu.net.sm.service;

import com.zhaoxi.edu.net.model.Order;
import com.zhaoxi.edu.net.sm.mapper.OrderMapper;
import org.springframework.transaction.annotation.Transactional;

public class OrderServiceImpl implements OrderService {
    private OrderMapper orderDAO;

    public void setOrderDAO(OrderMapper orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional // 配置了基于注解驱动事务管理必须添加该注解
    public void addOrder(Order order) {
        orderDAO.insertOrder(order);
        // 故意抛出异常， 看看是否能正常回滚，如果能说明事务生效了，如果不能需要排查问题
        throw new RuntimeException("出现错误，事务进行回滚");
    }
}
