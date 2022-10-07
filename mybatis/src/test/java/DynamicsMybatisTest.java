import dynamics.Dao.UserDao;
import dynamics.domain.User;
import org.junit.Test;
import utils.MyBatisutils;
import utils.MyBatisutilsImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicsMybatisTest {

    @Test
    public void test1() throws IOException {

        MyBatisutils myBatisutils = new MyBatisutilsImpl();

        UserDao mapper = myBatisutils.getMyBatis().getMapper(UserDao.class);

        User user = new User();
//        user.setId(6);
//        user.setUsername("curry");
//        user.setPassword("123");

        List<User> userlist = mapper.findByCondition(user);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<User> userList_ = mapper.findByIds(ids);

        System.out.println(userList_);
    }
}
