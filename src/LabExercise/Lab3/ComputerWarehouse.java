package LabExercise.Lab3;

   
class Computer {
	protected int length, width, height;
	
	public Computer(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public Computer(Computer ob) {
		this.length = ob.length;
		this.width = ob.width;
		this.height = ob.height;
	}
	public Computer clone() {
		return new Computer(this);
	}

	public static float sumThreeVoulmes(Object o1, Object o2, Object o3) {
		if(o1 instanceof Computer && o2 instanceof Computer && o3 instanceof Computer) {
			return ((Computer) o1).getVolume()+((Computer) o2).getVolume()+((Computer) o3).getVolume();
		}
		return 0;
	}
	
	public String toString() {
		return this.getClass().getName()+" class-object, Length: "+length+", Width: "+width+", Height: "+height+", Volume:"+getVolume();
	}
	
	public int getVolume() {
		return 0;
	}
}

class Laptop extends Computer{
	public Laptop(int length, int width, int height) {
		super(length, width, height);
		this.screenType = "attached";
	}
	
	public Laptop(Laptop ob) {
		super(ob.length,ob.width,ob.height);
	}
	
	public Laptop clone() {
		return new Laptop(this);
	}

	protected String screenType;
	
	public String toString() {
		return this.getClass().getName()+" class-object, Length: "+length+", Width: "+width+", Height: "+height+", Volume:"+getVolume()+", ScreenType: "+screenType;
	}
	
	public int getVolume() {
		return this.length*this.width*this.height;
	}
}

class Desktop extends Computer{
	public Desktop(int length, int width, int height) {
		super(length, width, height);
		this.screenType = "separate";
	}
	
	public Desktop(Desktop ob) {
		super(ob.length,ob.width,ob.height);
	}
	
	public Desktop clone() {
		return new Desktop(this);
	}
	
	protected String screenType;
	
	public String toString() {
		return this.getClass().getName()+" class-object, Length: "+length+", Width: "+width+", Height: "+height+", Volume:"+getVolume()+", ScreenType: "+screenType;
	}
	
	public int getVolume() {
		return this.length*this.width*this.height;
	}
}


class DellLaptop extends Laptop{
	public DellLaptop(int length, int width, int height) {
		super(length, width, height);
		this.brand = "Dell";
	}
	
	public DellLaptop(DellLaptop ob) {
		super(ob.length,ob.width,ob.height);
	}
	
	public DellLaptop clone() {
		return new DellLaptop(this);
	}
	
	private String brand;
	
	public String toString() {
		return this.getClass().getName()+" class-object, Length: "+length+", Width: "+width+", Height: "+height+", Volume:"+getVolume()+", ScreenType: "+screenType+", Brand: "+brand;
	}
	
	public int getVolume() {
		return this.length*this.width*this.height;
	}
}


class Workstation extends Desktop{
	public Workstation(int length, int width, int height) {
		super(length, width, height);
	}
	
	public Workstation(Workstation ob) {
		super(ob.length,ob.width,ob.height);
	}
	
	public Workstation clone() {
		return new Workstation(this);
	}

	protected int volumeMultiplier = 2;
	
	public String toString() {
		return this.getClass().getName()+" class-object, Length: "+length+", Width: "+width+", Height: "+height+", Volume:"+getVolume()+", ScreenType: "+screenType+", VolumeMultiplier: "+volumeMultiplier;
	}
	public int getVolume() {
		return this.length*this.width*this.height*volumeMultiplier;
	}
}

class AlienDesktop extends Workstation{
	public AlienDesktop(int length, int width, int height) {
		super(length, width, height);
		this.brand = "Predator";
	} 
	
	public AlienDesktop(AlienDesktop ob) {
		super(ob.length,ob.width,ob.height);
	}
	public AlienDesktop clone() {
		return new AlienDesktop(this);
	}

	private String brand;
	
	public String toString() {
		return this.getClass().getName()+" class-object, Length: "+length+", Width: "+width+", Height: "+height+", Volume:"+getVolume()+", ScreenType: "+screenType+", Brand: "+brand;
	}
	
	public int getVolume() {
		return this.length*this.width*this.height;
	}
}


public class ComputerWarehouse {
	
	public static void FindBiggestRow(Computer displayObj[][]) {
		System.out.println("\n**FineBiggestRow(...)");
		int biggestSum = Integer.MIN_VALUE, row = 0;
		for(int i=0;i<displayObj.length;i++) {
			int tempSum = (int) Computer.sumThreeVoulmes(displayObj[i][0], displayObj[i][1], displayObj[i][2]);
			System.out.println("Row "+i+" has total volume of "+tempSum);
			if(biggestSum<tempSum) {
				biggestSum = tempSum;
				row = i;
			}
		}
		System.out.println("> Row "+row+" has the largest volume!");
	}
	
	public static void main(String args[]) {
		
		Computer compObj[][]=new Computer[10][3];

		System.out.println("Created a "+compObj.length+"x"+compObj[0].length+" matrix");
		
		Computer c = new Computer(0,0,0);
		Laptop l = new Laptop(30,20,5);
		Desktop d = new Desktop(50,30,45);
		Workstation ws = new Workstation(50, 30, 45);
		DellLaptop dell = new DellLaptop(35, 25, 10);
		AlienDesktop alien = new AlienDesktop(60, 40, 50);
		
		Computer obj[] = {c, l, d, ws, dell, alien};
		
		System.out.println("Generating "+compObj.length*compObj[0].length+" Computer objects and placing them in the array");
		
		for(int i=0;i<compObj.length;i++) {
			for(int j=0;j<compObj[i].length;j++) {
				compObj[i][j]=obj[(int)(Math.random()*100)%obj.length].clone();
			}
		}
		
		FindBiggestRow(compObj);
		
		System.out.println("\n"+ws);
	}
}
