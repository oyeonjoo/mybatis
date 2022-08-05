package ch06.presentation;

import java.util.List;

import ch06.domain.Employee;
import ch06.service.EmployeeService;

public class EmployeeIo {
	private EmployeeService employeeService;
	
	public EmployeeIo(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void play() {
		employeeService.getEmployees().forEach(System.out::println);
	}
}
