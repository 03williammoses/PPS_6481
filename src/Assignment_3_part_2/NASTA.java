package Assignment_3_part_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 	

abstract class CleverSIDC {
	int totalNumberOfStudents;

	public CleverSIDC(int totalNumberOfStudents) {
		this.totalNumberOfStudents = totalNumberOfStudents;
	}

	abstract void setSIDCThreshold(int Size);

	abstract void generate();

	abstract List<Integer> allKeys(CleverSIDC ob);

	abstract void add(CleverSIDC ob, int key, String value);

	abstract String remove(CleverSIDC ob, int key);

	abstract String getValues(CleverSIDC ob, int key);

	abstract int nextKey(CleverSIDC ob, int key);

	abstract int prevKey(CleverSIDC ob, int key);

	abstract List<Integer> rangeKey(int key1, int key2);
}

public class NASTA {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner ob = new Scanner(new FileInputStream("Resources/NASTA_Files/NASTA_test_file1.txt"));
		List<Integer> listLong = new ArrayList<>();
		while(ob.hasNextInt()) {
			listLong.add(ob.nextInt());
		}
		if(listLong.size()>100) {
			CleverSIDC c = new AVLTree(listLong.size());
			for(int key:listLong) {
				c.add(c, key, "School Name");
			}
			List<Integer> list = c.allKeys(c);
			for(int key:list) {
				System.out.println(key);
			}
		} else {
			CleverSIDC c = new AVLTree(listLong.size());
			for(int key:listLong) {
				c.add(c, key, "School Name");
			}System.out.println();
			List<Integer> list = c.allKeys(c);
			for(int key:list) {
				System.out.println(key);
			}
		}
		ob.close();
	}
}
