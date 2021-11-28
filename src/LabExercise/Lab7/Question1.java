package LabExercise.Lab7;

import java.util.Scanner;

public class Question1 {

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
		heap[top+1] = 0;
		heapify(top, 0);
		return temp;
	}

	public static void display() {
		for(int i=0;i<top;i++) {
			System.out.print(" "+heap[i]);
		}System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		heap = new int[(int)(Math.pow(2, (Math.log10(n)/Math.log10(2))+2)-1)];
		for(int i=0;i<n;i++) {
			heap[i]=ob.nextInt();
			top++;
		}
		System.out.print("HEAP BEFORE ADD:");
		display();
		add(ob.nextInt());
		System.out.print("HEAP AFTER ADD:");
		display();
		System.out.println("Min: "+removeMin());
		System.out.print("HEAP AFTER REMOVE:");
		display();
		ob.close();
	}

}

/**
 * 8
7
20
13
30
31
25
22
39
*/
