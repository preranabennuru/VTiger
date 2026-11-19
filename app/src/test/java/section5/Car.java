package section5;

public class Car {
	private String brand;
	private String model;
	private String fuelType;
	private double price;
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public void setModel(String model) {
		this.model=model;
	}
	public void setfuelType(String fuelType) {
		this.fuelType=fuelType;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getfuelType() {
		return fuelType;
	}
	public double getPrice() {
		return price;
	}

}
