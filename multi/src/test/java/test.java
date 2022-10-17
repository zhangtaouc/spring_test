import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zt.Dao.OrderDao;
import zt.domain.Order;
import zt.utils.MyBatisutils;

import java.io.IOException;
import java.util.List;

public class test {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = MyBatisutils.getMyBatis();
        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        List<Order> orderList = mapper.findAll();
        System.out.println(orderList);


    }
}
