package by.itacademy.javaenterprise.seledtsova;

import by.itacademy.javaenterprise.seledtsova.dao.CustomerDao;
import by.itacademy.javaenterprise.seledtsova.dao.OrderDao;
import by.itacademy.javaenterprise.seledtsova.dao.impl.CustomerDaoImpl;
import by.itacademy.javaenterprise.seledtsova.dao.impl.OrderDaoImpl;
import by.itacademy.javaenterprise.seledtsova.entity.Customer;
import by.itacademy.javaenterprise.seledtsova.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.saveCustomer(new Customer(24L, "Ivan", "Ivanov"));
        logger.info("Customer are added successfully");
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order(24L, 24L, 2));
        logger.info("Order are added successfully");
        orderDao.deleteOrderById(24);
        customerDao.deleteCustomerById(24);
        customerDao.getAll();
        orderDao.getAll();
    }
}
