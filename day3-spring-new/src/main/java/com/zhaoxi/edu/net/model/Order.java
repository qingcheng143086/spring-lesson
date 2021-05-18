package com.zhaoxi.edu.net.model;

import java.math.BigDecimal;

public class Order {
    private Integer orderId;
    private BigDecimal orderMoney;
    private String orderAddress;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderMoney=" + orderMoney +
                ", orderAddress='" + orderAddress + '\'' +
                '}';
    }
}
