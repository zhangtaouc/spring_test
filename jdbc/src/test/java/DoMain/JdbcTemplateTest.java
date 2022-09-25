package DoMain;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.beans.PropertyVetoException;
import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void test1() throws PropertyVetoException {
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/book");
        dataSource.setUser("root");
        dataSource.setPassword("zhangtao579");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据来源对象
        jdbcTemplate.setDataSource(dataSource);
        // 执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)", "tom", 5000);
        System.out.println(row);
    }
    // 使用配置文件
    @Test
    public void text2() {
        try {
            ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
            JdbcTemplate jdbc = app.getBean(JdbcTemplate.class);

            // 新增
            // int row = jdbc.update("insert into account values(?,?)", "tom21", 5000);

            // 删除
            // int row = jdbc.update("delete from account where name = ?", "tom");

            // 修改
            // int row = jdbc.update("update account set money=? where name=?",1, "tom1");

            // 查询多个
            // List<Account> accountList = jdbc.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
            // System.out.println(accountList);

            // 查询一个queryForObject
            // Account account = jdbc.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
            // System.out.println(account);

            // 查询数量
            Long num = jdbc.queryForObject("select count(*) from account where name = ?", Long.class, "t1om");
            System.out.println(num);
            System.out.println(JdbcTemplate.class);
        } catch (BeansException e) {
            System.out.println("数据库出问题");
            e.printStackTrace();
        } catch (DataAccessException e) {
            System.out.println("出错了");
            e.printStackTrace();
        }

    }
}
