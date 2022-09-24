package zt1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 标志是spring的核心配置类
@Configuration
// 让spring扫描哪个包
@ComponentScan("zt1")
//@Import(DataSourceConfigRaction.class) // 加载分包
public class SpringConfigration {
}
