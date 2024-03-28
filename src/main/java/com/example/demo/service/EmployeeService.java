package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public Employee getEmployeeById(int id) {
		return repository.findById(id).get();
	}

	public List<Employee> getAllEmployees() {
		return (List<Employee>) repository.findAll();
	}

	public Employee addEmployee(Employee employee) {

		if (employee.getName().isEmpty()) {
			throw new BusinessException("601", "Employee name is empty");
		}
		try {
			return repository.save(employee);
		} catch (Exception e) {
			throw new BusinessException("603", "Error occured while adding employee" + e.getMessage());
		}

	}

	public void deleteEmployeeById(int id) {
	}

}