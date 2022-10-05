package proxy.jdk;

public class Advice {
    public void before() {
        System.out.println("增强前");
    }

    public void afterRunning() {
        System.out.println("后置增强");
    }
}
