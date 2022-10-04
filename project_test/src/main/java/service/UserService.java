package service;

import domain.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    int addUser(User user, Object obj);

    User getUserByUsernameAndPassword(String username, String password);
}
