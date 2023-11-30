package com.gaurav.crudrest.dao;

import java.util.List;

import com.gaurav.crudrest.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public Employee createOrUpdateEmployee(Employee employee);
	public void deleteEmployeeByID(int id);

}
