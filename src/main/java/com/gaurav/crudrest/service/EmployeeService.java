package com.gaurav.crudrest.service;

import java.util.List;

import com.gaurav.crudrest.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public Employee createOrUpdateEmployee(Employee employee);
	public void deleteEmployeeByID(int id);
	
}
