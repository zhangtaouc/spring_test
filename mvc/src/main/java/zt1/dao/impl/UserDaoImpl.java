package zt1.dao.impl;

import org.springframework.stereotype.Component;
import zt1.dao.UserDao;
@Component("UserDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("你好");
    }
}
