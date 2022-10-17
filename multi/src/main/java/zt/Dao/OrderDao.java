package zt.Dao;

import zt.domain.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();
}
