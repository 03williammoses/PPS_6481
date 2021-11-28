package Assignment_Part_1;

import java.util.Stack;

public class Q3B {
	static Stack<Integer> maxElement = new Stack<>();
	public static void main(String[] args) {
		int arr[] = {4, 2, 14, 1, 18};
		for(int i=0;i<arr.length;i++) {
			push(arr[i]);
			System.out.println("Step "+(i+1)+" : Push "+arr[i]+", Current max : "+max());
		}
		System.out.println("Step 6 : Pop "+pop()+", Current max : "+max());
	}

	private static int max() {
		return maxElement.peek();
	}

	private static int pop() {
		if(maxElement.size()==0) {
			return -1;
		} else {
			return maxElement.pop();
		}
	}

	private static void push(int i) {
		if(maxElement.size()==0) {
			maxElement.push(i);
		} else if(maxElement.peek()>i) {
			maxElement.push(maxElement.peek());
		} else {
			maxElement.push(i);
		}
	}

}
