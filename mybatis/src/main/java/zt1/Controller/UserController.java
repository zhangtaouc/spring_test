package zt1.Controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import zt1.Dao.UserDao;
import zt1.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserController {
    public static void main(String[] args) throws IOException {

        // 获取核心配置
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> userList = mapper.findAll();

        System.out.println(userList);

        User user_ = mapper.findUserById(6);

        System.out.println(user_);

        System.out.println("张涛");


    }
}
