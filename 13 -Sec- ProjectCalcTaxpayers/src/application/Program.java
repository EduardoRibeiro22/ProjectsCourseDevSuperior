package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<TaxPayer>();

		System.out.print("Enter the number of tax payers: ");
		int taxPayers = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < taxPayers; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char individualOrCompany = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			sc.nextLine();

			if (individualOrCompany == 'i' || individualOrCompany == 'I') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				sc.nextLine();
				TaxPayer taxpayer1 = new Individual(name, anualIncome, healthExpenditures); 
				list.add(taxpayer1);
			} else if (individualOrCompany == 'c' || individualOrCompany == 'C') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				sc.nextLine();
				TaxPayer taxpayer2 = new Company(name, anualIncome, numberOfEmployees);
				list.add(taxpayer2);
			}
		}
		
		System.out.println("");
		
		Double total = 0.0;
		
		System.out.println("TAXES PAID");
		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer);
			total += taxPayer.tax();
		}
		
		System.out.println("");
		System.out.print("TOTAL TAXES: " + total);
		
		sc.close();
	}
}
