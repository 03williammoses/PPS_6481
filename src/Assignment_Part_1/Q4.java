package Assignment_Part_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Node{
	Node left;
	Node right;
	String data;
	public Node(String data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class Q4 {
	public static void main(String[] args) {
		try {
			Scanner ob = new Scanner(new FileReader("D:\\Project Files\\Comp6481_Assignment_1\\COMP_6481_Assignment_1\\src\\Assignment2\\test.txt"));
			while(ob.hasNext()) {
				System.out.println(ob.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
