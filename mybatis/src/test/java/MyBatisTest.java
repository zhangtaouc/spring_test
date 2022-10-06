import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void test1() throws IOException {
        // 获取核心配置
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作 namespace + sqlid
        List<User> userList = sqlSession.selectList("UserMapper.findAll");

        System.out.println(userList);

        // 释放资源
        sqlSession.close();
    }
}
