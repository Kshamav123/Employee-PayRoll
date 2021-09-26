package com.employeepayrolltest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.employeepayroll.EmployeePayRoll;
import com.employeepayroll.EmplyeePayRollService;

public class EmployeePayRollServiceTest {
	@Test
	public void readData_FromConsole() {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.readEmployeeDetails();
		
	}
	
	@Test
	public void printData_ToConsole() {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.printData();
		
	}
	
	@Test
	public void given3EmployeeDetails_WhenWrittenToFile_ShouldMatchEntries() throws IOException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		EmployeePayRoll employee = new EmployeePayRoll(112, "Jack", 50400);
		EmployeePayRoll employee1 = new EmployeePayRoll(113, "Bill", 220400);
		EmployeePayRoll employee2 = new EmployeePayRoll(114, "Williams", 940000);
		List<EmployeePayRoll> list = new ArrayList<EmployeePayRoll>();
		list.add(employee);
		list.add(employee1);
		list.add(employee2);
		employeePayrollService.writeToFile(list);
		employeePayrollService.printData();
		long entries = employeePayrollService.countLines();
		Assert.assertEquals(3, entries);
	}
}
