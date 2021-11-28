package LabExercise.Lab4;

import java.util.Scanner;

public class Problem1A {

	public static void findLargestSkyway(int sky[][]) {
		int N = sky.length;
		int largestSum = 0, startIndexI = 0, startIndexJ=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i+2<N && j+3<N) {
					int temp = sky[i][j]+sky[i][j+3]+sky[i+1][j]+sky[i+1][j+1]+sky[i+1][j+2]+sky[i+1][j+3]+sky[i+2][j]+sky[i+2][j+3];
					if(temp>largestSum) {
						largestSum = temp;
						startIndexI=i;
						startIndexJ=j;
					} else if(temp == largestSum && startIndexI>=i && startIndexJ>j) {
						largestSum = temp;
						startIndexI=i;
						startIndexJ=j;
					}
				}
			}
		} 
		System.out.println("The largest skyway is "+largestSum+" starting at ["+startIndexI+"]["+startIndexJ+"]");		
	} 
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int N = ob.nextInt();
		int sky[][]=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sky[i][j] = ob.nextInt();
			}
		}
		findLargestSkyway(sky);
		ob.close();
	}

}
