package service.impl;

import service.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome() {
        System.out.println("执行了");
    }
}
