package LabExercise.Lab5;

import java.util.Scanner;

public class Question2 {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		
		int lc = 0, rc = 0, lindex = -1, rindex = -1;
		
		int temp = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(temp<arr[i]) {
				temp = arr[i];
			} else {
				lc++;
				lindex = i;
			}
		}
		
		temp = arr[arr.length-1];
		
		for (int i = arr.length-2; i>=0; i--) {
			if(temp>arr[i]) {
				temp = arr[i];
			} else {
				rc++;
				rindex = i;
			}
		}
		
		if (rc == 0 && lc == 0) {
			System.out.println("Array is OK. No removed value");
		} else if (rc == 1) {
			System.out.println("Array is OK. Removed value " + arr[rindex] + " at index " + rindex);
		} else if (lc == 1) {
			System.out.println("Array is OK. Removed value " + arr[lindex] + " at index " + lindex);
		} else {
			System.out.println("No Solution Exists!");
		}
		
		s.close();
		
	}

}
