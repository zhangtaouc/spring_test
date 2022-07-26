import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
//    测试c3p0
    public void test1() throws Exception  {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/book");
        dataSource.setUser("root");
        dataSource.setPassword("zhangtao579");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/book");
        dataSource.setUsername("root");
        dataSource.setPassword("zhangtao579");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
//    测试手动加载数据源 druid的
    public void test3() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("jdbc.driver");
        String url = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("jdbc.username");
        String password = resourceBundle.getString("jdbc.password");

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    @Test
    // 测试spring帮忙产生c3p0的connection对象
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSources = app.getBean(DataSource.class);
//        xml文件里面的id
//        DataSource dataSources = (DataSource)app.getBean("dataSources");
        Connection connection = dataSources.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    // 测试spring帮忙产生druid的connection对象
    public void test5() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DataSource dataSources = app.getBean(DataSource.class);
//        xml文件里面的id
        DataSource dataSources = (DataSource)app.getBean("dataSources_d");
        Connection connection = dataSources.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
