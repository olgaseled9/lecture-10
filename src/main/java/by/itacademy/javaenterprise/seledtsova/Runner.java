package by.itacademy.javaenterprise.seledtsova;

import by.itacademy.javaenterprise.seledtsova.dao.CustomerDao;
import by.itacademy.javaenterprise.seledtsova.dao.Impl.CustomerDaoImpl;
import by.itacademy.javaenterprise.seledtsova.dao.Impl.OrderDaoImpl;
import by.itacademy.javaenterprise.seledtsova.dao.OrderDao;
import by.itacademy.javaenterprise.seledtsova.entity.Customer;
import by.itacademy.javaenterprise.seledtsova.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.addCustomer(new Customer(24, "Ivan", "Ivanov"));
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.addOrder(new Order(24, 24, "2021-11-09"));
        orderDao.deleteOrderById(24);
        customerDao.deleteCustomerById(24);
        System.out.println(customerDao.getAll());
        System.out.println(orderDao.getAll());

    }
}
