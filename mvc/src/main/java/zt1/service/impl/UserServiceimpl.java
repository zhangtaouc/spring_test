package zt1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zt1.dao.UserDao;
import zt1.service.UserService;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceimpl implements UserService {
    //    @Autowired
//    @Qualifier("UserDao")
    @Resource(name = "UserDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
