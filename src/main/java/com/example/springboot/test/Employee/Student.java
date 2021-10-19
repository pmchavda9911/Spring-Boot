package com.example.springboot.test.Employee;

import com.example.springboot.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.lang.ref.Reference;
import java.util.List;

@Scope("prototype")
@Component
@Entity
public class Student {
    @Id
    int student_id;

    String student_name;
    String department;

    @Column(nullable = false)
    int dept_d_id = 0 ;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false, insertable = false)
    Department dept;

    public Student() {}

    public Student(String student_name, int student_id,String department) {

        this.student_name = student_name;
        this.department = department;
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Department getDept() {return dept;}

    public void setDept(Department dept) {this.dept = dept;}

    public int getDept_d_id() {
        return dept_d_id;
    }

    public void setDept_d_id(int dept_d_id) {
        this.dept_d_id = dept_d_id;
    }

    @Override
    public String toString() {
        return "Student{" + "student_name='" + student_name + '\'' + ", department='" + department + '\'' + ", student_id=" + student_id + '}';
    }
}
