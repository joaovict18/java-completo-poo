package services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Employee;

public class EmployeeService {

	public void filterEmployeesBySalary (List<Employee> list, Predicate<Employee> criteria) {
		for (Employee emp : list) {
			if (criteria.test(emp)) {
				System.out.println(emp.getEmail());
			}
		}
	}
	
	public double filterEmployeesByInitialLetter (List<Employee> list, Predicate<Employee> criteria) {
		double sum = 0.0;
		for (Employee emp : list) {
			if (criteria.test(emp)) {
				sum += emp.getSalary();
			}
		}
		return sum;
	}
}
