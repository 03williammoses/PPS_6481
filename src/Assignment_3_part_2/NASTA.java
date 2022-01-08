package Assignment_3_part_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
abstract class CleverSIDC {
	int totalNumberOfStudents;

	public CleverSIDC(int totalNumberOfStudents) {
		this.totalNumberOfStudents = totalNumberOfStudents;
	}

	abstract void setSIDCThreshold(int Size);

	abstract int generate();

	abstract long[] allKeys(CleverSIDC ob);

	abstract void add(CleverSIDC ob, long key, String value);

	abstract String remove(CleverSIDC ob, long key);

	abstract String getValues(CleverSIDC ob, long key);

	abstract long nextKey(CleverSIDC ob, long key);

	abstract long prevKey(CleverSIDC ob, long key);

	abstract long[] rangeKey(long key1, long key2);
}

/**
 * The Class NASTA.
 */
public class NASTA {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		CleverSIDC c = null;
		System.out.println("Welcome to SIDC");
		System.out.println("List of files available to read");
		File folder = new File("Resources/NASTA_Files/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		String fileName = s.next();
		Scanner ob = new Scanner(new FileInputStream("Resources/NASTA_Files/" + fileName));
		System.out.println(fileName + " has been loaded and ready to read!");
		List<Integer> listLong = new ArrayList<>();		
		while (ob.hasNextInt()) {
			listLong.add(ob.nextInt());
		}
		System.out.println("The Threshold size has set to - "+listLong.size() );

		if (listLong.size() > 1000) {
			c = new AVLTree(listLong.size());
		} else {
			c = new LinkedList(listLong.size());
		}
		for (int key : listLong) {
			c.add(c, key, "School Name");
		}
		System.out.println("List loaded successfully!!!\n");	
		
		
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(c.allKeys(c)));
		long end = System.currentTimeMillis();
		System.out.println("Time took to print allKeys():" + ((end - start)/1000) + "s\n");
		
		long gen = c.generate();
		System.out.println("generate(): " + gen);
		c.add(c, gen, "School Name");
		
		start = System.currentTimeMillis();
		System.out.println(Arrays.toString(c.allKeys(c)));
		end = System.currentTimeMillis();
		System.out.println("Time took to print allKeys():" + ((end - start)/1000) + "s\n");
		
		System.out.println("remove(3326261): " + c.remove(c, 3326261));
		System.out.println(Arrays.toString(c.allKeys(c)));
		System.out.println("getValues(84629786): " + c.getValues(c, 84629786));
		System.out.println("prevKey(84629786): " + c.prevKey(c, 84629786));
		System.out.println("nextKey(84629786): " + c.nextKey(c, 84629786));
		System.out.print("rangeKey(): ");
		long[] arr = c.rangeKey(70188256, 84629786);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				System.out.print(arr[i]+", ");
			}else {
				break;
			}
		}

		ob.close();
	}
}
