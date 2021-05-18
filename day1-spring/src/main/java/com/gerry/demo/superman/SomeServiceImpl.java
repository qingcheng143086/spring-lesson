package com.gerry.demo.superman;

import org.springframework.stereotype.Service;

@Service("s")
public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl() {
        System.out.println("SomeServiceImpl->实例化");
    }

    @Override
    public void doSomething() {
        System.out.println("SomeServiceImpl->doSomething");
    }
}
