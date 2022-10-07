package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisutilsImpl implements MyBatisutils{
    @Override
    public SqlSession getMyBatis() throws IOException {

        // 获取核心配置
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }
}
