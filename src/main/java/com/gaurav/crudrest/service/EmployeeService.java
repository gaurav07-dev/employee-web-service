package com.gaurav.crudrest.service;

import java.util.List;
import java.util.Optional;

import com.gaurav.crudrest.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Optional<Employee> getEmployeeById(int id);
	public Employee createOrUpdateEmployee(Employee employee);
	public void deleteEmployeeByID(int id);
	
}
