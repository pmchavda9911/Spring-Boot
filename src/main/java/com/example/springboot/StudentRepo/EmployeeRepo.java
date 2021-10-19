package com.example.springboot.StudentRepo;

import com.example.springboot.test.Employee.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
}
