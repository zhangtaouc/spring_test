package zt.dao.impl;

import zt.dao.UserDao;
import org.springframework.stereotype.Component;

//<bean id="userDao" class="dao.impl.UserDaoImpl"></bean>
@Component("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("你好");
    }
}
