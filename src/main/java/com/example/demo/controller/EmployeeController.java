package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String getTest() {
		return "Hi sample";
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Employee empRetr = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(empRetr,HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
	}

	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		Employee empsaved = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(empsaved, HttpStatus.CREATED);
	}

	@PutMapping("/employeePut")
	public void updateEmployee(@RequestBody Employee employee) {
	}
}