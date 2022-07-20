import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.SomeService;
import service.impl.SomeServiceImpl;

public class SomeServiceImplTest {
    public static void main(String args[]) {
//        SomeService someService = new SomeServiceImpl();
//        someService.doSome();
        // 指定spring文件
        String config = "beans.xml";
        // 配置容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 获取对象名称
        SomeService someService = (SomeService) ctx.getBean("someService");
        someService.doSome();

    }
}
