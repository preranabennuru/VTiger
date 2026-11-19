package section5;

public class CarDetails {
	public static void main(String[] args) {
		Car c=new Car();
		c.setBrand("Porshe AG");
		c.setModel("911 GT3");
		c.setfuelType("Petrol");
		c.setPrice(9900000);
		System.out.println(c.getBrand());
		System.out.println(c.getModel());
		System.out.println(c.getfuelType());
		System.out.println(c.getPrice());
	}
}
