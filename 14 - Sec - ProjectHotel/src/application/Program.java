package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Reservation reservation = null;
		DateTimeFormatter ftm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.print("Room number: ");
		Integer roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy HH:mm:ss): ");
		String dateInString = sc.nextLine();
		LocalDateTime checkIn = LocalDateTime.parse(dateInString, ftm1);
		System.out.print("Check-out date (dd/MM/yyyy HH:mm:ss): ");
		String dateOutString = sc.nextLine();
		LocalDateTime checkOut = LocalDateTime.parse(dateOutString, ftm1);
		if (checkOut.isAfter(checkIn)) {
			 reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.print(reservation);
		} else {
			do {

				System.out.print("Check-out date must be after check-in date! Please type again!");
				System.out.print("\n" + "Check-in date (dd/MM/yyyy HH:mm:ss): ");
				dateInString = sc.nextLine();
				checkIn = LocalDateTime.parse(dateInString, ftm1);
				System.out.print("Check-out date (dd/MM/yyyy HH:mm:ss): ");
				dateOutString = sc.nextLine();
				checkOut = LocalDateTime.parse(dateOutString, ftm1);

			} while (!checkOut.isAfter(checkIn));

			reservation = new Reservation(roomNumber, checkIn, checkOut);
		}

		System.out.print("\n" + "Enter data to update the reservation: ");
		do {
			System.out.print("\n" + "Check-in date (dd/MM/yyyy HH:mm:ss): ");
			checkIn = LocalDateTime.parse(sc.nextLine(), ftm1);
			System.out.print("Check-out date (dd/MM/yyyy HH:mm:ss): ");
			checkOut = LocalDateTime.parse(sc.nextLine(), ftm1);
			if (checkOut.isAfter(checkIn)) {
				reservation.updateDates(checkIn, checkOut);
				break;
			} else {
				System.out.print("Check-out date must be after check-in date");
			}

		} while (true);

		sc.close();
	}
}
