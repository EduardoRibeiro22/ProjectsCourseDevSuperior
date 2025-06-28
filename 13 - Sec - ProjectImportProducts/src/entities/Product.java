package entities;

public class Product {

	private String name;
	private Double price;

	public Product() {
		
	}

	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String priceTag() {
		return "Commom";
	}

	@Override
	public String toString() {
		return String.format("%s $ %.2f", this.name, this.price);
	}
	
}
