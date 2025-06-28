package entities;

public class Employee {

	private String name;
	private Integer hours;
	protected Double valuePerHour;

	public Employee() {
	
	}

	public Employee(String name, Integer hours, Double valuePerHour) {
		super();
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	public String getName() {
		return name;
	}

	public Integer getHours() {
		return hours;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}
	
	public Double payment() {
		return hours * valuePerHour;
	}

	@Override
	public String toString() {
		return String.format("%s - %.2f", name, payment());
	}
}
