import config.User.User;
import config.UserDao.UserDao;
import config.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class configTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = MybatisUtils.getMybatisUtils();
//        User user = new User(11,"kdt", "123", new Date());
        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        mapper.save(user);
//        sqlSession.commit();
        List<User> userList = mapper.getAll();
        System.out.println(userList);
        sqlSession.close();
    }
}
