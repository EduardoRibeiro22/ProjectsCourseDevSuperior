package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.List;
import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<Employee>();

		System.out.print("Enter the number of employees: ");
		int employersQuantity = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < employersQuantity; i++) {
			System.out.print("\n" + "Employee #" + (i + 1) + " data: ");
			System.out.print("\n" + "Outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			sc.nextLine();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();

			if (outsourced == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				sc.nextLine();
				Employee employer1 = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(employer1);
			} else {
				Employee employer2 = new Employee(name, hours, valuePerHour);
				list.add(employer2);
			}
		}

		System.out.println();

		for (Employee employeePrint : list) {

			System.out.println(employeePrint);
		}
		sc.close();
	}
}
