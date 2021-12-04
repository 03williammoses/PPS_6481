package LabExercise.Lab9;

import java.util.Scanner;

class OAHash {
	int hashTable[];
	int hashSize = 19;
	int insertCount;

	public OAHash() {
		hashTable = new int[hashSize];
		insertCount = 0;
	}

	public boolean ifHashAvailable(int index) {
		return hashTable[index] == 0;
	}

	public int getNextPrimeNumber(int k) {
		for (int i = k;; i++) {
			boolean flag = false;
			for (int j = 2; j < k; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return i;
			}
		}
	}

	public boolean checkLoadFactor() {
		return (((insertCount + 1) * 100) / hashSize) <= 75;
	}

	public int findSecondHashValue(int k, boolean LF) {
		int q = 13;
		int index = k % hashSize;
		int count = 0;
		do {
			if (!LF) {
				System.out.println("Key " + k + " caused collision at index " + index);
			}
			index = (index + q - (k % q)) % hashSize;
			count++;
		} while (!ifHashAvailable(index));
		if (!LF) {
			System.out.println("Key " + k + " is inserted at index " + index);
			System.out.println("Insertion of " + k + " resulted in " + count + " Collisions\n");
		}
		return index;
	}

	public int findHashValue(int k, boolean LF) {
		if (!ifHashAvailable(k % hashSize)) {
			return findSecondHashValue(k, LF);
		} else {
			int x = k % hashSize;
			if (!LF) {
				System.out.println("Key " + k + " is inserted at index " + x);
				System.out.println("Insertion of " + k + " resulted in 0 Collisions\n");
			}
			return x;
		}
	}

	public void transformArray() {
		int newArr[] = hashTable;
		hashTable = new int[hashSize];
		for (int i = 0; i < newArr.length; i++) {
			if (newArr[i] != 0) {
				int hashIndex = findHashValue(newArr[i], true);
				hashTable[hashIndex] = newArr[i];
			}
		}
	}

	public void display() {
		for (int i = 0; i < hashTable.length - 1; i++) {
			if (hashTable[i] != 0) {
				System.out.print(hashTable[i] + ", ");
			} else {
				System.out.print("-1, ");
			}
		}
		if (hashTable[hashSize - 1] != 0) {
			System.out.print(hashTable[hashSize - 1] + ".");
		} else {
			System.out.print("-1.");
		}
		System.out.println();
	}

	public void insert(int k) {
		int hashIndex = findHashValue(k, false);
		hashTable[hashIndex] = k;
		insertCount++;
		if (!checkLoadFactor()) {
			System.out.println("\nLoad Factor is about to exceed 75%. Expanding table. ");
			System.out.println("\nContents of table before expansion is as follows: ");
			display();
			hashSize = getNextPrimeNumber((hashSize)*2);
			transformArray();
		}
	}
}

public class UseOAHash {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter a positive value that you want to insert in the hash table; or -1 to terminate:");
		OAHash o = new OAHash();
		int input;
		while((input=ob.nextInt())!=-1) {
			o.insert(input);
		}
		o.display();
		ob.close();
	}

}
