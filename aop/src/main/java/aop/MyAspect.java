package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
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
