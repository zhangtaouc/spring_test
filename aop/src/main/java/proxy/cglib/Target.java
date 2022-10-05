package proxy.cglib;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("你好");
    }
}
