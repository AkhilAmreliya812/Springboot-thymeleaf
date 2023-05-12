package com.swarck.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swarck.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
