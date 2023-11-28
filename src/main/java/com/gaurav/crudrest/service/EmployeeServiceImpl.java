package com.gaurav.crudrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaurav.crudrest.dao.EmployeeDao;
import com.gaurav.crudrest.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public Employee createOrUpdateEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeByID(int id) {
		employeeDao.deleteById(id);
	}


}
