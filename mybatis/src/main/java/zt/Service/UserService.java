package zt.Service;

import zt.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAll() throws IOException;
}
