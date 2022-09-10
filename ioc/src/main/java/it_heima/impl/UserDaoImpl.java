package it_heima.impl;

import it_heima.UserDao;

public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("你好");
    }
    public void init() {
        System.out.println("我初始化了");
    }
    public  void destory() {
        System.out.println("我销毁了");
    }
}
