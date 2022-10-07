package zt1.Dao;

import zt1.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findUserById(int id);
}
