package by.itacademy.javaenterprise.seledtsova.dao;

import by.itacademy.javaenterprise.seledtsova.entity.Order;

import java.util.List;

public interface OrderDao {

    Order addOrder(Order order);

    List<Order> getAll();

    void deleteOrderById(Integer orderId);
}

