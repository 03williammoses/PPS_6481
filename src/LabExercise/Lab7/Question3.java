package LabExercise.Lab7;

import java.util.Scanner;

class HashTable{
	public int hash[][];
	public int pointer[];
	public HashTable(int row, int col) {
		hash = new int[row][col];
		pointer = new int[row];
	}
	
	public int hashValue(int y) {
		return (4*y+7)%13;
	}
	
	public void hashAndAdd(int value) {
		int y = hashValue(value);
		hash[y][pointer[y]++] = value;
	}
	
	public int[] getCollisionMetadata() {
		int ret[] = {0,-1};
		for(int i=0;i<pointer.length;i++) {
			if(ret[0]+1<pointer[i]) {
				ret[0]=pointer[i]-1;
				ret[1]=i;
			}
		}
		return ret;
	}
}
public class Question3 {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		HashTable h = new HashTable(13, 13);
		for(int i=0;i<n;i++) {
			h.hashAndAdd(ob.nextInt());
		}
		System.out.println("MAX COLLISIONS: "+h.getCollisionMetadata()[0]);
		System.out.println("MAX COLLISION INDEX: "+h.getCollisionMetadata()[1]);
		ob.close();
	}

}
