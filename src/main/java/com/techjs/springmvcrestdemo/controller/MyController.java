package com.techjs.springmvcrestdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techjs.springmvcrestdemo.entity.Employee;
import com.techjs.springmvcrestdemo.exception_handler.NoSuchEmployeeException;
import com.techjs.springmvcrestdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class MyController 
{

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public List<Employee> showAllEmployees() 
	{
		return service.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) 
	{
		Employee employee = service.getEmployee(id);
		if (employee == null) 
		{
			throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
		}
		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) 
	{
		service.saveEmployee(employee);
		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) 
	{
		service.saveEmployee(employee);
		return employee;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) 
	{
		Employee employee = service.getEmployee(id);
		if (employee == null) 
		{
			throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
		}
		service.deleteEmployee(id);
		return "Employee with ID = " + id + " was deleted";
	}

}
