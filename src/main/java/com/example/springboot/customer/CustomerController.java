//package com.example.springboot.customer;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class CustomerController {
//
//    @GetMapping("/customer")
//    public Customer getCustomer(){
//        return new Customer("Ramesh","Rajkot");
//    }
//
//    @GetMapping("/customers")
//    public List<Customer> getStudents(){
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer("Ramesh","Baroda"));
//        customers.add(new Customer("Ram","Mumbai"));
//        customers.add(new Customer("Haresh","Ahmedabad"));
//        customers.add(new Customer("Mitesh","delhi"));
//        return customers;
//    }
//
//    //localhost:8079/customer/1/dev
////    @GetMapping("/customer/{id}/{name}")
////    public Customer customerPath(@PathVariable("id") int id, @PathVariable("name") String name){
////        return new Customer(id,name);
////    }
//
//    //localhost:8079/cus/id=1&name=dev
////    @GetMapping("/cus")
////    public Customer customerQuery(@RequestParam (name = "id")int id, @RequestParam(name = "name") String name){
////        return new Customer(id,name);
////    }
//
//}
