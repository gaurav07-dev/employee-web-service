package com.gaurav.crudrest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaurav.crudrest.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return entityManager.find(Employee.class, id);
	}
	
	@Override
	public Employee createOrUpdateEmployee(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public void deleteEmployeeByID(int id) {
		entityManager.remove(entityManager.find(Employee.class, id));
	}

	

}
