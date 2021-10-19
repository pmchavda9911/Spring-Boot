package com.example.springboot;

import com.example.springboot.test.Employee.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Scope(value = "prototype")
@Component
@Entity
@Table(name = "department")
public class Department {
    String Department_name;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Student> students;

    @Id
    int dId;

    public Department() {}

//    public Department(String Department_name, List<Student> students){
//        this.Department_name=Department_name;
//        this.students=students;
//    }

    public String getDepartment_name() {
        return Department_name;
    }

    public void setDepartment_name(String department_name) {
        this.Department_name = department_name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }
//    public List<Student> getStudents() {
//        for (Student students : students) {
//            System.out.println(students);
//        }
//        return students;
//    }


    @Override
    public String toString() {
        return getDepartment_name() ;
    }
}