package LabExercise.Lab5;

import java.util.Scanner;

public class Question1 {
	
	public static long[] reverse(long arr[],int i, int j) {
		if(i>j) {
			return arr;
		} else {
			arr[i]=arr[i]+arr[j]-(arr[j]=arr[i]);
			reverse(arr, i+1, j-1);
		}
		return arr;
	}
	
	public static long product(long arr[], int i) {
		if(i==0) {
			return arr[0];
		}
		return arr[i]*product(arr, i-1);
	}
	
	public static long summation(long arr[], int i) {
		if(i==0) {
			return arr[0];
		}
		return arr[i]+summation(arr, i-1);
	}
	
	public static void recursiveBreaker(long arr[]) {
		long part1[] = new long[(int) Math.ceil(((float)arr.length)/3)+1];
		long part2[] = new long[(int) Math.floor(((float)arr.length)/3)];
		long part3[] = new long[arr.length-part1.length-part2.length];
		for(int i=0;i<part1.length;i++) {
			part1[i] = arr[i];
		}
		for(int i=0;i<part2.length;i++) {
			part2[i] = arr[part1.length+i];
		}
		for(int i=0;i<part3.length;i++) {
			part3[i] = arr[part1.length+part2.length+i];
		}
		part2[part2.length-1] = product(part2, part2.length-1);
		part1 = reverse(part1, 0, part1.length-1);
		part3[part3.length-1] = summation(part3, part3.length-1);
		
		System.out.println("p1 = "+(part1.length-1)+", p2 = "+(part1.length+part2.length-1));
		for(int i=0;i<arr.length-1;i++) {
			if(i<part1.length) {
				arr[i]=part1[i];
			} else if (i<part1.length+part2.length) {
				arr[i]=part2[i-part1.length];
			} else {
				arr[i]=part3[i-part1.length-part2.length];
			}
			System.out.print(arr[i]+", ");
		}
		arr[arr.length-1]=part3[part3.length-1];
		System.out.println(arr[arr.length-1]);
	}
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		long arr[] = new long[n];

		for(int i=0;i<n;i++) {
			arr[i]=ob.nextInt();
		}
		recursiveBreaker(arr);
	}

}
