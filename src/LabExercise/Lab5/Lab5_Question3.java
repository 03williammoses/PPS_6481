package LabExercise.Lab5;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Lab5_Question3 {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fs = new FileInputStream("D:\\Project Files\\COMP6481_LAB\\Lab5\\mystery.dat");
			Scanner ob = new Scanner(fs);
			ObjectInputStream ois = new ObjectInputStream(fs);
			String s = ois.readUTF();
			System.out.println(s);
			while(s!=null) {
				System.out.print(ois.readInt());
				System.out.print(ois.readChar());
				System.out.print(ois.readChar());
				System.out.print(ois.readChar());
				System.out.println(s);
				s=ois.readUTF();
			}
			
		} catch (EOFException e) {
		}
	}

}
