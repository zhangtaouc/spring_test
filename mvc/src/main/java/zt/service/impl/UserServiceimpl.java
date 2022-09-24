package zt.service.impl;
import zt.dao.UserDao;
import zt.service.UserService;
public class UserServiceimpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
