package dynamics.Dao;

import dynamics.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findByCondition(User user);

    List<User> findAll();

    List<User> findByIds(List<Integer> ids);
}
