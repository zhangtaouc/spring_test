package it_heima.factory;

import it_heima.UserDao;
import it_heima.impl.UserDaoImpl;
//静态工厂配置
public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
