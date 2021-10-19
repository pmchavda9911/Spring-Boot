package com.example.springboot.customer.Repository;

import com.example.springboot.customer.Customer;
//import com.example.springboot.customer.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerImpl {

    @Autowired
    CustomerRepo customerRepo ;

//     public CustomerImpl(){};

//     public CustomerImpl(CustomerRepo customerRepo){
////         super();
//         this.customerRepo=customerRepo;
//     }

    public Customer saveCustomer(Customer customer) {
        Customer cust = customerRepo.save(customer);
          return cust;
    }

    public List<Customer> getCustomers() {
        List<Customer> list = (List<Customer>) customerRepo.findAll();
        return list;
    }

    public Customer getCustomerById(int id) {
        Customer customer = customerRepo.findById(id).get();
        return customer;
    }

    public void deleteCustomerById(int id){
         customerRepo.deleteById(id);
         System.out.println("Record Deleted");
    }

    public void updateCustomer(Customer customer, int id){
//        Customer customer1 = customerRepo.findById(id).get();
//
//        customer1.setCustomerId(customer.getCustomerId());
//        customer1.setCustomerName(customer.getCustomerName());
//        customer1.setCity(customer.getCity());
//        customer1.setOrder(customer.getOrder());
        customer.setCustomerId(id);
        customerRepo.save(customer);
    }
}
