package by.itacademy.javaenterprise.seledtsova.dao.impl;

import by.itacademy.javaenterprise.seledtsova.connection.ConnectionToDataBase;
import by.itacademy.javaenterprise.seledtsova.dao.CustomerDao;
import by.itacademy.javaenterprise.seledtsova.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.postgresql.util.JdbcBlackHole.close;

public class CustomerDaoImpl implements CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);
    private static final String SELECT_FROM_CUSTOMER_TABLE = "SELECT customer_id, first_name, last_name FROM Customers ORDER BY last_name LIMIT 100 OFFSET 3";
    private static final String DELETE_CUSTOMER_FROM_CUSTOMER_TABLES = "DELETE FROM Customers WHERE customer_id = ?";
    private static final String ADD_NEW_CUSTOMER = "INSERT INTO Customers (customer_id, first_name, last_name) VALUES (?,?,?)";

    @Override
    public Customer saveCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionToDataBase.getConnection();
            preparedStatement = connection.prepareStatement(ADD_NEW_CUSTOMER);
            preparedStatement.setLong(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Not able to add  " + customer.getClass().getName(), e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionToDataBase.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_CUSTOMER_TABLE);
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getLong("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customers.add(customer);
            }
        } catch (SQLException exception) {
            logger.error("Not able to add  customer", exception);
            throw new RuntimeException("Connection is not available", exception);
        } finally {
            close(statement);
            close(connection);
        }
        return customers;
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionToDataBase.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_FROM_CUSTOMER_TABLES);
            preparedStatement.setInt(1, customerId);
            int affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Deleting customer from database failed", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }
}



