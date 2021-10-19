package com.example.springboot.StudentRepo;

import com.example.springboot.test.Employee.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
}
