package zt.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zt.Dao.UserDao;
import zt.Service.UserService;
import zt.domain.User;

import java.io.IOException;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() throws IOException {
        List<User> userList = userDao.getAll();
        return userList;
    }
}
