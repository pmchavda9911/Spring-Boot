package com.example.springboot.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;

    @Column(name = "order_value", nullable = false)
    float order_value;

    @OneToOne(mappedBy = "purchasedOrder",cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID")
    @JsonBackReference
//    @JsonManagedReference
    Customer customer;

    public Order(){}

    public Order(int orderId, float order_value) {
        this.orderId = orderId;
        this.order_value = order_value;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getValue() {
        return order_value;
    }

    public void setValue(float value) {
        this.order_value = value;
    }
//
//    public Date getDate() {
//        return order_date;
//    }
//
//    public void setDate(Date date) {
//        this.order_date = date;
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
