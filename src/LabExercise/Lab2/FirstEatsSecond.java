package LabExercise.Lab2;


import java.util.Arrays;
import java.util.Scanner;

public class FirstEatsSecond {
	public static void FirstSecond(int arr[]) {
		int firstValue = -1, secondValue = -1, firstCount = 0, secondCount = -1;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(min>arr[i]) {
				min = arr[i];
			}else if(max<arr[i]) {
				max = arr[i];
			}
		}
		int countHash[]=new int[max-min+1];
		for(int i=0;i<arr.length;i++) {
			countHash[arr[i]-min]++;
		}
		for(int i=0;i<arr.length;i++) {
			if(firstCount<countHash[arr[i]-min] && countHash[arr[i]-min]>1) {
				secondValue=firstValue;
				secondCount=firstCount;
				firstValue=arr[i];
				firstCount=countHash[arr[i]-min];
			}else if(secondCount<countHash[arr[i]-min] && countHash[arr[i]-min]<firstCount && countHash[arr[i]-min]>1) {
				secondValue=arr[i];
				secondCount=countHash[arr[i]-min];
			}
		}
		if(secondCount!=-1) {
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==secondValue) {
					arr[i]=firstValue;
				}
			}
		}
	}
	
	
	
	public static void main(String args[]) {
		Scanner ob = new Scanner(System.in);
		int arraySize = ob.nextInt();
		int arr[]= new int[arraySize];
		for(int i=0;i<arraySize;i++) {
			arr[i]=ob.nextInt();
		}
		FirstSecond(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
