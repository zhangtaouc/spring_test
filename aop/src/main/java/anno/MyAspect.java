package anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("MyAspect")
@Aspect // 标注下面是一个切面
public class MyAspect {

    // 配置前置增强
//    @Before("execution(public void anno.Target.save())")
    @Before("execution(* anno.Target.*(..))")
    public void MyBefore() {

        System.out.println("前置增强");
    }


    public void MyAfter() {

        System.out.println("后置增强");
    }

    public Object MyAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("绕前增强");
        Object obj = pjp.proceed(); // 切点
        System.out.println("绕后增强");
        return obj;
    }

    public void MyThrowing() {
        System.out.println("增强异常");
    }
}
