package LabExercise.Lab3;
 
import java.util.Scanner;

public class Problem1A {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int joker = ob.nextInt();
		int n = ob.nextInt();
		int A[] = new int[n];
		int X[] = new int[n];
		for(int i=0;i<n;i++) {
			A[i] = ob.nextInt();
		}
		for(int i=n-1;i>0;i--) {
			int diff = 0;
			for(int j = i-1;j>=0;j--) {
				if(A[i]>A[j]) {
					diff += (A[i]-A[j]);
					if(diff == joker) {
						diff = 0;
						break;
					}
				} else {
					break;
				}
			}
			X[i] = diff;
		}
		for(int i=0;i<n;i++) {
			System.out.print(X[i]+" ");
		}
	}
}
