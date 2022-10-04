package service.impl;

import dao.RoleDao;
import dao.UserDao;
import domain.Role;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roleList = roleDao.findRoleByUserId(id);
            user.setRoleList(roleList);
        }
        return userList;
    }

    @Override
    public int addUser(User user, Object list) {
        int num = userDao.addUser(user, list);
        return num;
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username, password);
        return user;
    }
}
