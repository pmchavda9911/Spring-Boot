package com.example.springboot.customer.Repository;

import com.example.springboot.customer.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Integer> {
}
