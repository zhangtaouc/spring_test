package dao.imp;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbc;

    public void setJdbc(JdbcTemplate jdbc) {
        System.out.println("初始化jdbc");
        this.jdbc = jdbc;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = jdbc.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public int addUser(User user, Object list) {
        int num = jdbc.update("insert into sys_user values(?,?,?,?,?)", null,user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return num;
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = jdbc.queryForObject("select * from sys_user where username =? and password =?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }
}
