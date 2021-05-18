package com.zhaoxi.edu.net.jdbc;

import com.zhaoxi.edu.net.model.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 测试Spring的自带的JDBC操作
 */
public class TestsJdbcTemplate {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("jdbc/spring-tx-xml.xml");
        // 获取JDBCTemplate对象
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        // testQuery(jdbcTemplate);
        testInsert(jdbcTemplate);
    }

    private static void testInsert(JdbcTemplate jdbcTemplate) {
        int row = jdbcTemplate.update("INSERT INTO `bootdb`.`order_1991`(`order_id`, `order_money`, `order_address`) VALUES (444, 3333.00, 'dkd')");
        throw new RuntimeException("我出错了");
        // 抛出了异常居然数据持久化到了数据库中
        // System.out.println(row > 0 ? "成功" : "失败");
    }

    /**
     * 查询的方法
     * @param jdbcTemplate
     */
    private static void testQuery(JdbcTemplate jdbcTemplate) {
        // 把查询的结果转换为对应类型对象集合
        List<Order> query = jdbcTemplate.query("select * from order_1991", new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setOrderMoney(new BigDecimal(resultSet.getDouble("order_money")));
                order.setOrderAddress(resultSet.getString("order_address"));
                return order;
            }
        });
        System.out.println(query);

        Map<String, Object> queryForMap = jdbcTemplate.queryForMap("select * from order_1990 where order_id = 1");
        System.out.println(queryForMap);
    }
}
