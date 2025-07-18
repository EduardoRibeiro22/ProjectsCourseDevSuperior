package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

	private LocalDate manufactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	
	@Override
	public String priceTag () {
		return "used";
	}

	@Override
	public String toString() {
		return String.format("%s(%s) $%.2f (Manufacture date: %s)", super.getName(), priceTag(), super.getPrice(), this.manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	
}
