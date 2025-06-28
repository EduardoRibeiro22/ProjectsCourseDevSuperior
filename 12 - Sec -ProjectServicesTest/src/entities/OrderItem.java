package entities;

import java.util.Random;


public class OrderItem {
	private Integer quantity;
	private Double price;
	private int id;
	
	Random random =  new Random();

	private Product product;

	public OrderItem(Integer quantity, Double price, Product product) {
		
		this.id = (Integer) random.nextInt(1000);
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}


	public Double getPrice() {
		return price;
	}


	public Product getProduct() {
		return product;
	}
	
	public Integer getId() {
		return id;
	}

	public Double subTotal() {
		return quantity * price;
	}

	@Override
	public String toString() {
		return String.format("ID: %d,Name: %s, Value: %.2f, Quantity: %d, Subtotal: %.2f",this.id, product.getName(),this.price,this.quantity,subTotal());
	}
	
}
