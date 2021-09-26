package com.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class EmplyeePayRollService {
	static List<EmployeePayRoll> list = new ArrayList<EmployeePayRoll>();

	String path = "/Users/kshamavidyananda/eclipse-workspace/EmployeePayRoll/data/employee.txt";

	/**
	 * method to read employee details such as employee id, name, salary
	 */
	public  void readEmployeeDetails() {

		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id ");
		int empId = scanner.nextInt();

		System.out.println("Enter employee name");
		String empName = sc.nextLine();

		System.out.println("Enter employee salary");
		float empSalary = sc.nextFloat();

		EmployeePayRoll employee = new EmployeePayRoll(empId, empName, empSalary);
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setSalary(empSalary);
		list.add(employee);
	}

	/**
	 * method to print employee details to console
	 */
	public void printEmployeeDetails() {

		System.out.println("Writing employee details to console :\n" + list);
	}
	
	/**
	 * UC-4 To create an EmployeePayRollService to store the data in a file
	 * 
	 * @param employeeList
	 */
	public void writeToFile(List<EmployeePayRoll> employeeList) {
		final StringBuffer empBuffer = new StringBuffer();
		employeeList.forEach(new Consumer<EmployeePayRoll>() {
			public void accept(EmployeePayRoll employee) {
				String employeeDataString = employee.toString().concat("\n");
				empBuffer.append(employeeDataString);
			}
		});

		try {
			Files.write(Paths.get(path), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method to display the data from employee.txt
	 *
	 */
	public void printData() {
		try {
			Files.lines(new File(path).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * method to return number of entries in the file
	 * 
	 * @return it returns the count
	 * @throws IOException
	 */
	public long countLines() throws IOException {
		long entries = 0;
		entries = Files.lines(new File(path).toPath()).count();
		System.out.println("Number of entries "+entries);
		return entries;
	}

}
