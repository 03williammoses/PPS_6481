package LabExercise.Lab6;

import java.util.Scanner;

/**
 * 
 * Question 1 
 * 
 * @author W_STALIN
 * 
 * Time Complexity = O(n^2)
 * Space Complexity = O(1)
 * 
 */
public class Question1 {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int row = ob.nextInt();
		int col = ob.nextInt();
		int arr[][]=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=ob.nextInt();
			}			
		}
		int sum =0; 
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(i==0) {
					sum+=arr[i][j];
				}else if(i!=0 && arr[i-1][j]!=0 && arr[i][j]!=0) {
					sum+=arr[i][j];
				}
			}
		}
		System.out.println("Total Income is: "+sum);
		
		ob.close();
	}

}
