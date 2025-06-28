package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import entities.enums.OrderStatus;

public class Order {
	private Integer id;
	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;

	Random random = new Random(); // Use to generate random numbers;

	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order(LocalDateTime moment, OrderStatus status, Client client) {

		this.id = random.nextInt();
		this.moment = moment;
		this.status = status;
		this.client = client;

	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMomentTime(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		items.add(item);

	}

	public void removeItem(OrderItem item) {
		boolean confirmRemove = false;

		Integer idProduct = item.getId();
		Iterator i = items.iterator();
		while (i.hasNext()) {
			OrderItem removeItem = (OrderItem) i.next();
			if (removeItem.getId().equals(idProduct)) {
				items.remove(removeItem);
				confirmRemove = true;
			}

		}

		if (confirmRemove == false) {

			System.out.print("Item não encontrado! ");
		}

	}

	public Double total() {
		Double result = 0.0;
		
		for (OrderItem x : items) {
			result += x.subTotal();
		}
		return result;
	}

	@Override
	public String toString() {
		return "ORDER SUMMARY: "
				+"\n" + "Order moment: " + moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
				+"\n" + "Order status: " + this.status.toString() + 
				"\n" + this.client.toString() + "\n" +
				"Order items: " + items + "\n" +
				"Total price: " + total();
		
	}
	
}
