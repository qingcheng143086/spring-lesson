package com.zhaoxi.edu.net.jdbc.service;

import com.zhaoxi.edu.net.jdbc.dao.OrderMapper;
import com.zhaoxi.edu.net.model.Order;
import org.springframework.transaction.annotation.Transactional;

public class OrderServiceImpl implements OrderService {
    private OrderMapper orderDAO;

    public void setOrderDAO(OrderMapper orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        orderDAO.insertOrder(order);
        throw new RuntimeException("出现错误，事务进行回滚");
    }
}
