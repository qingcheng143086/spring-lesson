package com.zhaoxi.edu.net.jdbc.dao;

import com.zhaoxi.edu.net.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDAOImpl implements OrderDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertOrder(Order order) {
        String sql = "INSERT INTO `bootdb`.`order_1991`\n" +
                "                (`order_id`, `order_money`, `order_address`)\n" +
                "                    VALUES (?,?,?)";
        Object[] param = {
             order.getOrderId(),
             order.getOrderMoney(),
             order.getOrderAddress()
        };
        return jdbcTemplate.update(sql, param);
    }
}
