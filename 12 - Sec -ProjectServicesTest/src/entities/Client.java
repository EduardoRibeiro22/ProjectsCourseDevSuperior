package entities;

import java.time.LocalDate;
import java.util.Random;

public class Client {
	private String name;
	private int id;
	private String email;
	private LocalDate birthDate;

	Random random = new Random();

	public Client(String name, String email, LocalDate birthDate) {

		this.id = random.nextInt();
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Client: %s %s - %s", this.name, getBirthDate().toString(), this.email);
	}
}
