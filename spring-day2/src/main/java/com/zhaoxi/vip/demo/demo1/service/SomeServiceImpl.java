package com.zhaoxi.vip.demo.demo1.service;

import com.zhaoxi.vip.demo.demo1.dao.SomeDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class SomeServiceImpl implements SomeService {

    @Autowired
    private SomeDAO someDAO;

    public  SomeServiceImpl() {
        System.out.println("SomeServiceImpl->");
    }

    @Override
    public void doSomething() {
        someDAO.doAccessData();
    }
}
