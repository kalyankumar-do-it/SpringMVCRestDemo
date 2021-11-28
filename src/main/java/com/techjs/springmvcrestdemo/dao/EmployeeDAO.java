package com.techjs.springmvcrestdemo.dao;

import java.util.List;
import com.techjs.springmvcrestdemo.entity.Employee;

public interface EmployeeDAO 
{

	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployee(int id);

	void deleteEmployee(int id);
}
