package com.example.springboot.customer.Repository;

import com.example.springboot.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


//@Component
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
