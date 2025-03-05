package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import services.EmployeeService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		System.out.print("Salary: ");
		double limitSalary = sc.nextDouble();
		
		List<Employee> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				String employeeName = fields[0];
				String employeeEmail = fields[1];
				Double employeeSalary = Double.parseDouble(fields[2]);
				list.add(new Employee(employeeName, employeeEmail, employeeSalary));
				line = br.readLine();
			}
			
			list.sort((emp1, emp2) -> emp1.getName().toUpperCase().compareTo(emp2.getName().toUpperCase()));
			
			System.out.println("Email of people whose salary is more than " + limitSalary + ":");
			EmployeeService auxiliarEmployeeService = new EmployeeService();
			auxiliarEmployeeService.filterEmployeesBySalary(list, emp -> emp.getSalary() >= 2000.00);
			System.out.print("Sum of salary of people whose name starts with 'M': ");
			System.out.println(new EmployeeService().filterEmployeesByInitialLetter(list, emp -> emp.getName().charAt(0) == 'M'));
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}

	}

}
