package LabExercise.Lab6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * Question 3
 * 
 * @author W_STALIN
 * 
 * Time Complexity = O(n logn)
 * 	 n - to iterate each value
 * 	 logn - to search the element in the array using Binary Search
 *      Together it will be O(n logn)
 * 
 * Space Complexity = O(n)
 *   here in this problem I have taken an extra space same size of the file items which is O(n).
 * 
 */
public class Question3 {
	static int arr[] = new int[200];
	static int top = -1;
	
	public static int bSearch(int search) {
		int left=0,right=top;
		while(left<=right) {
			int mid = (left+right)/2;
			if(arr[mid]<0 && arr[left]!=search) {
				left = left + 1;
			} else if(arr[mid]<0 && arr[right]!=search) {
				right = right - 1;
			} else if(arr[mid]==search) {
				return mid;
			} else if(search<arr[mid]) {
				right = mid-1; 
			} else {
				left = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		try {
			Scanner br = new Scanner(new FileInputStream("D:\\Project Files\\PPS_6481\\src\\LabExercise\\Lab6\\Paris.txt"));
			
			while(br.hasNextInt()) {
				arr[++top] = br.nextInt();
			}
			
			int outARR[]=new int[top+1];
			
			int target = 150;
			
			for(int i=0,j=0;i<=top && j<=top;i++) {
			
				int value = bSearch(target-arr[i]);
				
				if(arr[i]>=0) {
					outARR[j++]=arr[i];
				} 
				
				if(value!=-1 && arr[i]>=0) {
					outARR[j++]=arr[value];
					arr[value]=-arr[value];
				}
			}
			
			for(int i=0;i<outARR.length;i++) {
				System.out.println(outARR[i]);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception!!!");
		}
	}

}
