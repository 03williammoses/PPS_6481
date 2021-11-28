package LabExercise.Lab4;

import java.util.Scanner;
/*
 * 1	2	3	4	5	6	
 * 1	3	6	10	15	21
 * 
 * 
 */
public class Problem1B {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=ob.nextInt();
		}
		int cum_sum[] = new int [n];
		cum_sum[0]=arr[0];
		for(int i=1;i<n;i++) {
			cum_sum[i]=arr[i]+cum_sum[i-1];
		}
		int finalIndex = -1;
		int total = 0;
		for(int i=n-1;i>=0;i--) {
			total+=arr[i];
			if(total==cum_sum[i]) {
				finalIndex = i;
			}
		}
		if(finalIndex==-1) {
			System.out.println("No Solution Exists; returning "+finalIndex);
		} else {
			System.out.println("Solution Exists at Index "+finalIndex);
		}
	}

}
