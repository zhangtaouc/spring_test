package config.UserDao;

import config.User.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> getAll();

}
