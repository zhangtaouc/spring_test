package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 创建目标对象
        final Target target = new Target();

        // 获得增强对象
        final Advice advice = new Advice();

        // 返回值就是动态对象
        TargetInterface proxy =  (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标对象类加载器
                target.getClass().getInterfaces(), // 目标对象数组
                new InvocationHandler() {
                    // 调用代理对象的任何方法都是执行invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.afterRunning();
                        Object invoke = method.invoke(target,args);
                        advice.before();
                        return invoke;
                    }
                }
        );
        // 调用代理接口方法
        proxy.save();
    }
}
