package zt.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;

// 标志是spring的核心配置类
@Configuration
// 让spring扫描哪个包
@ComponentScan("zt")
@Import(DataSourceConfigRaction.class) // 加载分包
public class SpringConfigration {
}
