package LabExercise.Lab3;

import java.util.Scanner;

public class Problem1B {
	public static void main(String args[]) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		boolean flag = true;
		ob.nextLine();
		int size = ob.nextLine().length();
		for(int i=1;i<n;i++) {
			int temp = ob.nextLine().length();
			if(temp>size) {
				flag = false;
				break;
			}
			size = temp;
		}
		System.out.println(flag?"YES":"NO");
	}
}
