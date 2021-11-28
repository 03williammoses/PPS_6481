package Assignment_Part_1;

import java.util.Stack;

public class Q3 {

	private static Stack<Integer> stackElements = new Stack<>();
	private static Stack<Integer> maxValue = new Stack<>();

	public static void push(int a) {
		stackElements.push(a);
		if (stackElements.size() == 1) {
			maxValue.add(a);
		} else if (a > max()) {
			maxValue.add(a);
		} else {
			maxValue.add(max());
		}
	}
	public static int max() {
		return maxValue.peek();
	}
	public static int pop() {
		if(stackElements.size() > 0) {
			maxValue.pop();
			return stackElements.pop();
		}
		return -1;
	}
	public static void main(String[] args) {
		int arr[] = {4, 2, 14, 1, 18};
		for(int i=0;i<arr.length;i++) {
			push(arr[i]);
			System.out.println("Step "+(i+1)+" : Push "+arr[i]+", Current max : "+max());
		}
		System.out.println("Step 6 : Pop "+pop()+", Current max : "+max());
	}

}
