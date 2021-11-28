package Assignment_Part_2;

//-------------------------------------------------------------
//Assignment 1
//@WILLIAM MOSES STALIN JEBADOSS
//Written by : WILLIAM MOSES STALIN JEBADOSS - 40186129
//-------------------------------------------------------------
public class Computer {

	private String brand;
	private String model;
	private long sn;
	private double price;
	private static int count;
	
	public Computer()
	{
		this.brand = "BrandName";
		this.model = "ModelName";
		this.sn = 404;
		this.price = 404;
		setCount();
	}
	
	public Computer(String brand, String model, long sn, double price)
	{
		this.brand = brand;
		this.model = model;
		this.sn = sn;
		this.price = price;
		setCount();
	}
	
	public Computer(Computer c)
	{
		this.brand = c.brand;
		this.model = c.model;
		this.sn = c.sn;
		this.price = c.price;
		setCount();
	}
	
	public static int getCount() {
		return count;
	}

	public static void setCount() {
		Computer.count++;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSn() {
		return sn;
	}

	public void setSn(long sn) {
		this.sn = sn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}
	
	public static int findNumberOfCreatedComputers() {
		return count;
	}
	
	public boolean equals(Computer compObj) {
		return compObj != null && this.getClass().equals(compObj.getClass()) 
				&& this.brand.equals(compObj.brand) && this.model == compObj.model 
				&& this.price == compObj.price;
	}
	
	public String toString() {
		return "Brand \t: " + this.brand + "\nModel \t: " + this.model + "\nSerial Number \t: " + this.sn
				+ "\nPrice \t: " + this.price;
	}
}
