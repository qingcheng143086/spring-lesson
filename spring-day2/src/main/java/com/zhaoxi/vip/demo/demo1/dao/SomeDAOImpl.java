package com.zhaoxi.vip.demo.demo1.dao;

public class SomeDAOImpl implements SomeDAO {

    public SomeDAOImpl() {
        System.out.println("SomeDAOImpl->");
    }

    @Override
    public void doAccessData() {
        System.out.println("SomeDAOImpl->doAccessData");
    }
}
