package Assignment_Part_1;

import java.util.Arrays;
import java.util.Stack;

public class Q1 {
	
	public static void method1(int arr[]) {
		int temp = arr[0], count = 1, pointerStart = 0 ;
		for(int i=1;i<arr.length;i++) {
			if(temp == arr[i]) {
				count++;
			} else {
				if(count > 1) {
					System.out.println("Value "+temp+" is repeated "+count+" times starting at Index "+pointerStart);
				}
				count = 1;
				pointerStart = i;
				temp = arr[i];
			} 
		}
		if(count > 1) {
			System.out.println("Value "+temp+" is repeated "+count+" times starting at Index "+pointerStart);
		}
	}
	public static void method2(int arr[]) {
		Stack<Integer> stackObject = new Stack<>();
		int pointerStart = 0;
		for(int i=0;i<arr.length;i++) {
			if(stackObject.isEmpty()) {
				stackObject.add(arr[i]);
				pointerStart = i;
			} else if(stackObject.get(0) == arr[i]) {
				stackObject.push(arr[i]);
			} else {
				if(stackObject.size() > 1) {
					System.out.println("Value "+stackObject.get(0)+" is repeated "+stackObject.size()+" times starting at Index "+pointerStart);
				}
				stackObject.clear();
				stackObject.add(arr[i]);
				pointerStart = i;
			}
		}
		if(stackObject.size() > 1) {
			System.out.println("Value "+stackObject.get(0)+" is repeated "+stackObject.size()+" times starting at Index "+pointerStart);
		}
	}
	public static void main(String[] args) {
		int arr1[] = {22, 9, 61,61, 61, 21, 0, 9, 9, 9, 9, 35, 81,81, 9, 5, 5};
		int arr2[] = arr1;
		System.out.println("\n*-*-*-*-*-*-*-*-*-* Method 1 *-*-*-*-*-*-*-*-*-*-*\n");
		method1(arr1);
		System.out.println("\n*-*-*-*-*-*-*-*-*-* Method 2 *-*-*-*-*-*-*-*-*-*-*\n");
		method2(arr2);
		System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	}
}
