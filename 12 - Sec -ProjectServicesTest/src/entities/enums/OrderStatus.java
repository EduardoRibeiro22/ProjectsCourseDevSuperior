package entities.enums;

import java.util.Scanner;

public enum OrderStatus {
	
	
	PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERY;

	static String pending_payment = "pending_payment";
	static String processing = "processing";
	static String shipped = "shipped";
	static String delivery = "delivery";
	

	public static OrderStatus selectStatus(String status, Scanner sc) {
		
		do {

			if (status.equalsIgnoreCase(pending_payment)) {
				return PENDING_PAYMENT;
			} else if (status.equalsIgnoreCase(processing)) {
				return PROCESSING;
			} else if (status.equalsIgnoreCase(shipped)) {
				return SHIPPED;
			} else if (status.equalsIgnoreCase(delivery)) {
				return DELIVERY;
			} else {
				System.out.println("Invalid status, please enter a valid value:");
				status = sc.nextLine();
			}
			
		} while (true);
	}
}
