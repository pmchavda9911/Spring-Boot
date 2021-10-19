package com.example.springboot.StudentRepo;

import com.example.springboot.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {
}
