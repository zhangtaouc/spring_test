package it_heima.factory;

import it_heima.UserDao;
import it_heima.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
