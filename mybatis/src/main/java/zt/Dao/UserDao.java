package zt.Dao;

import zt.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    List<User> getAll() throws IOException;
}
