package LabExercise.Lab2;

import java.util.Scanner;

public class PrintPyramids {
	public static void main(String ar[]) {
		Scanner ob = new Scanner(System.in);
		int N = ob.nextInt();
		for(int i=0;i<N;i++) {
			for(int j=0;j<(N-i-1)*2;j++) {
				System.out.print("-");
			}
			for(int j=0;j<=i*2;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
