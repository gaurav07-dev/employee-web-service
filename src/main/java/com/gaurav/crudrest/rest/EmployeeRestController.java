package com.gaurav.crudrest.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.crudrest.entity.Employee;
import com.gaurav.crudrest.exceptions.NoEmployeeFoundException;
import com.gaurav.crudrest.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{employee_id}")
	public Optional<Employee> getEmployeeById(@PathVariable int employee_id){
		Optional<Employee> employee = employeeService.getEmployeeById(employee_id);
		if(employee==null) {
			throw new NoEmployeeFoundException("No employee found in database with id: " + employee_id);
		}
		return employee;
	}
	
	@PostMapping("/employee")
	public Employee createNewEmployee(@RequestBody Employee employee) {
		//setting to 0 for create as we will be using merge() which would create new entry only if PK is 0, else it will update
		employee.setId(0);
		return employeeService.createOrUpdateEmployee(employee);
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.createOrUpdateEmployee(emp);
	}
	
	
	@DeleteMapping("/employee/{employee_id}")
	public String deleteEmployeeByID(@PathVariable int employee_id) {
		if(employeeService.getEmployeeById(employee_id)==null) {
			throw new NoEmployeeFoundException("Employee with id \'" +employee_id+ "\' does not exist in database");
		}
		employeeService.deleteEmployeeByID(employee_id);
		return "Employee deleted from DB. ID: " + employee_id;
	}

}
