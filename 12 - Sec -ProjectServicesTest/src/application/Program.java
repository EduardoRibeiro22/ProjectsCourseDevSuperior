package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter Client Data: ");
		System.out.print("\n" + "Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date DD/MM/YYYY: ");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(sc.nextLine(),fmt);
		Client client = new Client(name, email, data);
		System.out.print("Enter order data: ");
		System.out.print("\n" + "Status: ");
		OrderStatus status = OrderStatus.selectStatus(sc.nextLine(), sc);
		System.out.print("\n" + "How many items to this order? ");
		Integer itemsQuantity = sc.nextInt();
		sc.nextLine();
		
		Order order = new Order(LocalDateTime.now(),status,client);
		
		for (int i = 1; i <= itemsQuantity; i++) {
			System.out.print("Enter #"+ i +" item data");
			System.out.print("\n" + "Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
			System.out.print("Product Quantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
		}
		
		System.out.println(order);
	}
}
