package by.itacademy.javaenterprise.seledtsova.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer orderId;
    private Integer customerId;
    private String dateOrder;
    private List<Customer> customers;

    public Order(Integer orderId, Integer customerId, String dateOrder) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.dateOrder = dateOrder;
    }
}

