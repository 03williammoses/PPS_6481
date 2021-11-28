package LabExercise.Lab2;
  
class Clothing {
	private double Price;
	private static int count=0;
	
	public Clothing(double price) {
		setPrice(price);
		count++;
		System.out.println("Clothing Class has successfully initialized with its attribute(Price"+price+")");
	}
	public void setPrice(double Price) {
		this.Price=Price;
	}
	public String getNumberOfCreatedObjects() {
		return count+" Clothing objects were created";
	}
	public boolean equals(Object ob) {
		return this.Price == ((Clothing)ob).Price && this.getClass().equals(ob.getClass()) && this.getNumberOfCreatedObjects().equals(((Clothing)ob).getNumberOfCreatedObjects());
	}
}

class Dresses extends Clothing{
	private double height;

	private static int count=0;
	public Dresses(double price, double height) {
		super(price);
		setHeight(height);
		count++;
		System.out.println("Dresses Class has successfully initialized with its attribute(Height="+height+")");
	}
	public void setHeight(double height) {
		this.height=height;
	}
	public String getNumberOfCreatedObjects() {
		return count+" Dress objects were created";
	}
	public boolean equals(Object ob) {
		return this.height == ((Dresses)ob).height && this.getClass().equals(ob.getClass()) && this.getNumberOfCreatedObjects().equals(((Dresses)ob).getNumberOfCreatedObjects());
	}
}

class Jacket extends Clothing{
	private String color;
	private static int count=0;
	
	public Jacket(double price, String color) {
		super(price);
		setColor(color);
		count++;
		System.out.println("Jacket Class has successfully initialized with its attribute(Color="+color+")");
	}
	public void setColor(String color) {
		this.color=color;
	}
	public String getNumberOfCreatedObjects() {
		return count+" Jacket objects were created";
	}
	public boolean equals(Object ob) {
		return this.color == ((Jacket)ob).color && this.getClass().equals(ob.getClass()) && this.getNumberOfCreatedObjects().equals(((Jacket)ob).getNumberOfCreatedObjects());
	}
}

class Shirts extends Dresses{
	
	private double size;
	private double width;
	private double height;

	private static int count=0;
	
	public Shirts(double price, double height, double size, double width) {
		super(price, height);
		setHeight(height);
		setSize(size);
		setWidth(width);
		count++;
		System.out.println("Shirts Class has successfully initialized with its attribute(Height="+height+", Size="+size+", Width="+width+")");
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	public String getNumberOfCreatedObjects() {
		return count+" Shirt objects were created";
	}
	public boolean equals(Object ob) {
		return this.size == ((Shirts)ob).size && this.width == ((Shirts)ob).width && this.height == ((Shirts)ob).height && this.getClass().equals(ob.getClass()) && this.getNumberOfCreatedObjects().equals(((Shirts)ob).getNumberOfCreatedObjects());
	}
}

class SportsJacket extends Jacket{
	private int year;
	private String countryOfManufacture;

	private static int count=0;
	
	public SportsJacket(double price, String color, int year, String countryOfManufacture) {
		super(price, color);
		setYear(year);
		setCountryOfManufacture(countryOfManufacture);
		count++;
		System.out.println("SportsJacket Class has successfully initialized with its attribute(Year="+year+", CountryOfManufacture="+countryOfManufacture+")");
	}
	
	public void setYear(int year) {
		this.year = year;
	}	

	public void setCountryOfManufacture(String countryOfManufacture) {
		this.countryOfManufacture = countryOfManufacture;
	}
	
	public void setPrice(double Price) {
		if(Price>=50) {
			super.setPrice(Price);
			System.out.println("Price $"+Price+" got set successfully");
		} else {
			System.out.println("Entered Price $"+Price+" is not set as its below $50");
		}
	}
	public String getNumberOfCreatedObjects() {
		return count+" SportsJacket objects were created";
	}	
	public boolean equals(Object ob) {
		return this.year == ((SportsJacket)ob).year && this.countryOfManufacture == ((SportsJacket)ob).countryOfManufacture && this.getClass().equals(ob.getClass()) && this.getNumberOfCreatedObjects().equals(((SportsJacket)ob).getNumberOfCreatedObjects());
	}
}
public class UtilizeClothing {
	public static void main(String ar[]) {

		System.out.println("\n\n---------------------------------\nClothing object initialization\n\n");
		Clothing clothingObject = new Clothing(52);
		System.out.println("\n\n---------------------------------\n\n");
		Clothing dressesObject[] = new Dresses[2];
		Clothing jacketObject[] = new Jacket[3];
		System.out.println("\n\n---------------------------------\nDressObject initialization\n\n");
		for(int i=0;i<dressesObject.length;i++) {
			dressesObject[i]=new Dresses(51, 22);
		}

		System.out.println("\n\n---------------------------------\nJacetObject initialization\n\n");
		
		for(int i=0;i<jacketObject.length;i++) {
			jacketObject[i]=new Jacket(51, "Blue");
		}

		System.out.println("\n\n---------------------------------\ngetNumberOfCreatedObjects()\n\n");
		
		System.out.println(dressesObject[0].getNumberOfCreatedObjects());
		System.out.println(jacketObject[0].getNumberOfCreatedObjects());
		System.out.println(clothingObject.getNumberOfCreatedObjects());


		System.out.println("\n\n---------------------------------\nSportsJacket Object initialization\n\n");
		
		Clothing sportsJacket[] = new SportsJacket[3];
		for(int i=0;i<sportsJacket.length;i++) {
			sportsJacket[i] = new SportsJacket(55, "Blue", 2020, "US");
		}
		
		
		System.out.println("\n\n--------------------------------\n\n");
		System.out.println("SportsJacket object is equal with another of its own class object with same value so it returns -> "+sportsJacket[0].equals(sportsJacket[1]));
		System.out.println("Jacket object is not equal with sportsJacket object so it returns -> "+jacketObject[0].equals(sportsJacket[1]));
		sportsJacket[1].setPrice(60);
		sportsJacket[1].setPrice(40);
		System.out.println("SportsJacket object is equal with another of its own class object with same value so it returns -> "+sportsJacket[0].equals(sportsJacket[1]));
	}
}
