package LabExercise.Lab7;

import java.util.Scanner;

public class Question2 {

	public static int heap[];
	
	public static int top = 0;
	
	public static void heapify(int n, int i) {
		
		int largest = i, l = 2*i+1, r=2*i+2;
		
		if(l<n && heap[l]<heap[largest]) {
			largest = l;
		}
		
		if(r<n && heap[r]<heap[largest]) {
			largest = r;
		}
		
		if(largest!=i) {
			heap[i]=heap[i]+heap[largest]-(heap[largest]=heap[i]);
			heapify(n, largest);
		}
	}
	
	public static void add(int item) {
		heap[top++]=item;
		int child = top-1;
		int parent = (child-1)/2;
		while(parent >= 0 && heap[parent] > heap[child]) {
			heap[parent] = heap[parent] + heap[child] - (heap[child]=heap[parent]);
			child = parent;
			parent = (child-1)/2;
		}
	}
	
	public static int removeMin() {
		int temp = heap[0];
		heap[0]= heap[--top];
//		heap[top+1] = 0;
		heapify(top, 0);
		return temp;
	}

	public static void display() {
		for(int i=0;i<top;i++) {
			if(i!=0) {
				System.out.print(" ");
			}
			System.out.print(heap[i]);
		}System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		int sorted[] = new int[(int)(Math.pow(2, (Math.log10(n)/Math.log10(2))+2)-1)]; 
		heap = new int[n];
		for(int i=0;i<n;i++) {
			heap[i]=ob.nextInt();
			top++;
		}
		System.out.print("HEAP BEFORE REMOVALS: ");

		for(int i=0;i<n;i++) {
			display();
			sorted[i]=removeMin();
		}
		System.out.print("SORTED VALUES:");
		for(int i=0;i<n;i++) {
			System.out.print(" "+sorted[i]);
		}System.out.println();
		ob.close();
	}

}
/**
 * 9
7
20
13
29
31
25
22
39
30
 */
