package zt.Dao.Impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import zt.Dao.UserDao;
import zt.domain.User;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAll() throws IOException {

        // 获取核心配置
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("UserMapper.findAll");

        sqlSession.close();

        return userList;
    }
}
