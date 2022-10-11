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
        User user = new User();

        // 获取核心配置
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作 namespace + sqlid

        // 保存 更新需要提交操作
        // user.setUsername("curry");
        // user.setPassword("123");
        // sqlSession.insert("UserMapper.save", user);
        // sqlSession.commit();

        // 修改
        // user.setId(1);
        // user.setUsername("tom");
        // user.setPassword("456");
        // sqlSession.update("UserMapper.update", user);
        // sqlSession.commit();

        // 删除
        sqlSession.delete("UserMapper.delete", 1);
        sqlSession.commit();


        // 查询
         List<User> userList = sqlSession.selectList("UserMapper.findAll");
        System.out.println(userList);
//        User user1 = sqlSession.selectOne("UserMapper.getUserById", 2);
//        System.out.println(user1);

        // 释放资源
        sqlSession.close();
    }
}
