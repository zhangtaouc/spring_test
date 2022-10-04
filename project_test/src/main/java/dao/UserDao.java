package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    int addUser(User user, Object obj);

    User getUserByUsernameAndPassword(String username, String password);
}
