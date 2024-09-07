package com.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}