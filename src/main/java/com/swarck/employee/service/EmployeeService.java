package com.swarck.employee.service;

import java.util.List;

import com.swarck.employee.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	public void saveEmployee(Employee employee);
	public Employee getEmpEmployeeById(long id);
	public void deleteEmployeeById(long id);
	
}
