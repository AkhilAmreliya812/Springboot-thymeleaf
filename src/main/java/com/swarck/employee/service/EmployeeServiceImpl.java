package com.swarck.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swarck.employee.model.Employee;
import com.swarck.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmpEmployeeById(long id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("No employee found for id " + id);
		}

		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

}
