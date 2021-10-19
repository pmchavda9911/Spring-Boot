package com.example.springboot.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int customerId;

    @Column(name = "customer_name")
    String customerName;

    @Column(name = "city")
    String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonManagedReference
//    @JsonBackReference
    Order purchasedOrder;

    public Customer() {}

    public Customer(int customerId, String customerName, String city) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.city = city;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public Order getOrder() {return purchasedOrder;}

    public void setOrder(Order order) {this.purchasedOrder = order;}

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName='" + customerName + '\'' +
                ", city='" + city + '\'' + ", order=" +  + '}';
    }
}
