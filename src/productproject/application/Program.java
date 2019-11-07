package productproject.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import productproject.entities.Department;
import productproject.entities.HourContract;
import productproject.entities.Worker;
import productproject.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter Department's Name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter Worker Data --- ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double workerBaseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
		
		System.out.print("How Many Contracts to this Worker ? ");
		int n = sc.nextInt();
		
		for(int i = 1;  i <= n; i++) {
			System.out.println("Enter Contract #" + i + " Data --- ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		} 
		System.out.print("\nEnter Month and Year to Calculate Income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("\nName: " +  worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income For : " + monthAndYear + " : " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}