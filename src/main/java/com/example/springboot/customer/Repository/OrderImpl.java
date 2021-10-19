package com.example.springboot.customer.Repository;

import com.example.springboot.customer.Customer;
import com.example.springboot.customer.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderImpl {

    @Autowired
    OrderRepo orderRepo ;

    public Order saveOrder(Order order) {
        Order order1 = orderRepo.save(order);
        return order1;
    }

    public List<Order> getOrders() {
        List<Order> list = (List<Order>) orderRepo.findAll();
        return list;
    }

    public Order getOrderById(int id) {
        Order order = orderRepo.findById(id).get();
        return order;
    }

    public void deleteOrderById(int id){
        orderRepo.deleteById(id);
        System.out.println("Record Deleted");
    }

    public void updateOrder(Order order, int id){
        order.setOrderId(id);
        orderRepo.save(order);
    }
}
