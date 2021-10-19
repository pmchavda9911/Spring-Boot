package com.example.springboot.customer.Controller;

import com.example.springboot.customer.Customer;
//import com.example.springboot.customer.CustomerInterface;
import com.example.springboot.customer.Order;
import com.example.springboot.customer.Repository.CustomerImpl;
import com.example.springboot.customer.Repository.CustomerRepo;
import com.example.springboot.customer.Repository.OrderImpl;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Customer")
public class CustomeController {

    @Autowired
    CustomerImpl customerImpl;

    @Autowired
    OrderImpl orderImpl;

    @PostMapping("/addCustomer")
    Customer addCustomer(@RequestBody Customer customer){
        Customer cust = customerImpl.saveCustomer(customer);
        return cust;
    }

    @PostMapping("/addOrder")
    Order addOrder(@RequestBody Order order){
        Order order1 = orderImpl.saveOrder(order);
        return order1;
    }

    @GetMapping("/customerId/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        Customer customer = customerImpl.getCustomerById(id);
        return customer;
    }

    @GetMapping("/orderId/{id}")
    public Order findOrderById(@PathVariable int id) {
        Order order1 = orderImpl.getOrderById(id);
        return order1;
    }

    @GetMapping("/all")
        public List<Customer> allCustomers(){
        List<Customer> list = customerImpl.getCustomers();
        return list;
    }

    @GetMapping("/orders/all")
    public List<Order> allOrders(){
        List<Order> list = orderImpl.getOrders();
        return list;
    }

    @DeleteMapping("/customerId/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerImpl.deleteCustomerById(id);
    }

    @DeleteMapping("/orderId/{id}")
    public void deleteOrder(@PathVariable int id){
        orderImpl.deleteOrderById(id);
    }

    @PutMapping("/customerId/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id){
        customerImpl.updateCustomer(customer, id);
        return customer;
    }

    @PutMapping("/orderId/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable int id){
        orderImpl.updateOrder(order, id);
        return order;
    }

    @GetMapping("/home")
    public String home(){
        return "Customer controller works";
    }

//    CustomerInterface customerInterface;
    //    @Autowired
    CustomerRepo customerRepo;
//
//    public CustomeController(CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;

//    }
    //    public CustomeController(){};
//
//    public CustomeController(CustomerInterface customerInterface) {
//        super();
//        this.customerInterface = customerInterface;

//    }
//    @PostMapping
//    ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
//        return new ResponseEntity<Customer>(customerInterface.saveCustomer(customer), HttpStatus.CREATED);

//    }
//    @PostMapping("/addcustomer")
//    public Customer addcustomer(@RequestBody Customer customer){
//        return customerRepo.save(customer);
//    }
}
