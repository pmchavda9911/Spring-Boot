package com.example.springboot.test.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int Eid;

    String Ename;

    String city;

    public Employee(){}

    public Employee(int eid, String ename, String city) {
        Eid = eid;
        Ename = ename;
        this.city = city;
    }

    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" + "Eid=" + Eid + ", Ename='" + Ename + '\'' + ", city='" + city + '\'' + '}';
    }
}
