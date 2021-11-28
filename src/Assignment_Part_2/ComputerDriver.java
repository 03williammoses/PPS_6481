package Assignment_Part_2;


import java.util.InputMismatchException;
import java.util.Scanner;

//-------------------------------------------------------------
//Assignment 1
//@WILLIAM MOSES STALIN JEBADOSS
//Written by : WILLIAM MOSES STALIN JEBADOSS - 40186129
//-------------------------------------------------------------

public class ComputerDriver {

	public static final String PASSWORD = "password";
	public static Computer inventory[];

	public static int getAvailableSpace() {
		int existingCount = 0;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				existingCount++;
			}
		}
		return (inventory.length - existingCount);
	}

	public static void addComputerInfo(Scanner ob, int numOfComp) {
		int compNum = 1;
		boolean first = true;
		ob.nextLine();
		for (int i = 0; i < inventory.length && compNum <= numOfComp; i++) {
			if (inventory[i] != null) {
				continue;
			} else {
				String inputType = "";
				try {
					System.out.println("enter the details of computer : " + compNum);
					if (!first) {
						ob.nextLine();
					}
					System.out.println("Enter the brand name : ");
					String brandName = ob.nextLine();
					System.out.println("Enter the model name : ");
					String modelName = ob.nextLine();
					if (compNum == 1) {
						first = false;
					}
					System.out.println("Enter the serial number : ");
					inputType = "long";
					long serialNumber = ob.nextLong();
					System.out.println("Enter the price : ");
					inputType = "double";
					double price = ob.nextDouble();
					inventory[i] = new Computer(brandName, modelName, serialNumber, price);
					System.out.println("Computer Added Successfully!!");
					compNum++;
				} catch (InputMismatchException e) {
					System.out.println("Input type is wrong." + inputType + " is expected. Try again!!");
					i--;
				}
			}
		}

	}

	public static void findCheaperThan(double price) {
		
		boolean isAvailable = false;
		for (int i = 0; i < inventory.length && inventory[i] != null; i++) {
			if (inventory[i].getPrice() < price) {
				isAvailable = true;
				System.out.println(inventory[i]+"\n-----------------------------------\n");
			}
		}
		
		if(!isAvailable) {
			System.out.println("There are no available computers available for this price...");
		}
	}

	public static void findComputersBy(String brandName) {
		
		boolean isExists = false;
		for (int i = 0; i < inventory.length && inventory[i] != null; i++) {
			if (inventory[i].getBrand().equals(brandName)) {
				isExists = true;
				System.out.println(inventory[i]+"\n-----------------------------------\n");
			}
		}
		if(!isExists) {
			System.out.println("There are no Computers found or exists under this brandName - "+brandName);
		}
	}

	public static void displayComputerInfo(int compNum) {
		System.out.println("\nDisplay Info:\nComputer : " + compNum + "\n" + inventory[compNum]);
	}

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		boolean menuTest = true;
		int maxComputers = 0;
		while (menuTest) {
			System.out.println("Hello World!!! Please enter the maximum number of computer your stores can hold...");
		
			try {
				maxComputers = ob.nextInt();
				inventory = new Computer[maxComputers];
			} catch (InputMismatchException e) {
				System.out.println("Integer format is expected... Try again...");
				ob.nextLine();
				continue;
			}
			menuTest = false;
		}
		boolean inputFlag = true;
		while (inputFlag) {
			System.out.print("What do you want to do?\r\n" + "1. Enter new computer (password required)\r\n"
					+ "2. Change information of a computer (password required)\r\n"
					+ "3. Display all computers by a specific brand\r\n"
					+ "4. Display all computers under a certain a price.\r\n" + "5. Quit\r\n"
					+ "Please enter your choice > ");
			int userInput;
			try {
				userInput = ob.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Integer format is expected... Try again...");
				ob.nextLine();
				continue;
			}
			switch (userInput) {
			case 1:
				System.out.println("Please enter your password : ");
				int count = 1;
				ob.nextLine();
				boolean success = false;
				while (count <= 3) {
					String password = ob.nextLine();
					count++;
					if (password.equals(PASSWORD)) {
						success = true;
						System.out.println("Enter the number of computers you need to add : ");
						int noOfComputers = ob.nextInt();
						int available = getAvailableSpace();
						if (available >= noOfComputers) {
							addComputerInfo(ob, noOfComputers);
						} else if (available == 0) {
							System.out.println("No space available to store a new computer");
						} else {
							System.out.println("Only " + available + " computers available "
									+ "Kindly enter your the details");
							addComputerInfo(ob, available);
						}
						break;
					} else {
						if (count != 4) {
							System.out.println("The password you entered is incorrect...Try again!!");
						}
					}
				}

				if (count == 4 && !success) {
					System.out.println("Warning! you have reached your maximum number of try...");
				}
				break;

			case 2:
				System.out.println("Please enter your password : ");
				count = 1;
				ob.nextLine();
				boolean entered = false;
				while (count <= 3) {
					String password = ob.nextLine();
					count++;
					if (password.equals(PASSWORD)) {
						entered = true;
						boolean userContinues = true;
						while (userContinues) {
							System.out.println("Enter the computer number to change information : ");
							int computerNo = ob.nextInt();
							if (computerNo < inventory.length && inventory[computerNo] != null) {

								displayComputerInfo(computerNo);
								boolean isContinue = true;
								while (isContinue) {
									System.out.println("What information would you like to" + "change?\n" + "1. brand\n"
											+ "2. model\n" + "3. SN\n" + "4. price\n" + "5. Quit\n"
											+ "Enter your choice >");
									String choice = ob.next();
									switch (choice.trim()) {
									case "1":
										System.out.println("Enter the brand name to update : ");
										ob.nextLine();
										String newBrandName = ob.nextLine();
										inventory[computerNo].setBrand(newBrandName);
										System.out.println("Brand name updated successfully!!");
										displayComputerInfo(computerNo);
										break;
									case "2":
										System.out.println("Enter the model name to update : ");
										ob.nextLine();
										String newModelName = ob.nextLine();
										inventory[computerNo].setBrand(newModelName);
										System.out.println("Model name updated succesfully!!");
										displayComputerInfo(computerNo);
										break;
									case "3":
										System.out.println("Enter the Serial Number to update : ");
										try {
											long newSN = ob.nextLong();
											inventory[computerNo].setSn(newSN);
											System.out.println("Serial number updated successfully!!");
											displayComputerInfo(computerNo);
										} catch (InputMismatchException e) {
											System.out.println("Input should be a long type");
										}
										break;
									case "4":
										System.out.println("Enter the new price : ");
										try {
											double newPrice = ob.nextDouble();
											inventory[computerNo].setPrice(newPrice);
											System.out.println("Price updated succesfully!!");
											displayComputerInfo(computerNo);
										} catch (InputMismatchException e) {
											System.out.println("Input should be a double type");
										}
										break;
									case "5":
										isContinue = false;
										userContinues = false;
										count = 9;
										break;
									default:
										System.out.println("Invalid Option entered. Try again!!");
									}
								}
							} else {
								System.out.println("The entered computer number does not exist."
										+ "\nType 1 if you want to try with other number or any other "
										+ "character to return to the " + "main menu.");
								String option = ob.next();
								if (!option.trim().equals("1")) {
									userContinues = false;
									count = 404;
								}
							}
						}
					} else {
						System.out.println("Password entered is incorrect.Try again!!");
					}
				}
				if (!entered && count == 4) {
					System.out.println("Sorry! you have reached the maximum no.of tries");
				}

				break;
			case 3:
				System.out.println("Enter the brand name");
				ob.nextLine();
				String brandName = ob.nextLine();
				findComputersBy(brandName);
				break;
			case 4:
				System.out.println("Enter the price");
				double price = ob.nextDouble();
				findCheaperThan(price);
				break;
			case 5:
				inputFlag = false;
				System.out.println("Application is quitting!!");
			}
		}
		ob.close();
	}
}
