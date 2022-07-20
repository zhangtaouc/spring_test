import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.SomeService;

public class myTest {
    @Test
    public void test01() {
        String config = "beans.xml";
        ApplicationContext atx = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService)atx.getBean("someService");
        someService.doSome();
    }

}
