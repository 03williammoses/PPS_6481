package Assignment_Part_1;

import java.util.Scanner;

public class Q2 {
	public static int caseNumber = 0;
	public static int stack1[];
	public static int top1 = -1;
	
	public static int stack2[];
	public static int top2 = -1;
	
	public static void push1(int item) {
		if(top1==stack1.length-1) {
			System.out.println("There is no space in stack:1 ");
			if(caseNumber==2) {
				System.out.println("Checking stack:2 for space");
				if(top2!=stack2.length) {
					push2(item);
				} else {
					System.out.println("Stack:2 is also full. So, it can't be inserted");
				}
			}
		} else {
			stack1[++top1]=item;
			System.out.println("Item "+item+" has inserted in stack:1 at index - "+top1);
		}
	}
	
	public static void pop1() {
		if(top1==-1) {
			System.out.println("There is no element to pop at stack:1");
		} else {
			System.out.println("Element "+stack1[--top1]+" has been popped out");
		}
	}
	
	public static void push2(int item) {
		if(top2==stack2.length-1) {
			System.out.println("There is no space in stack:2 ");
			if(caseNumber==2) {
				System.out.println("Checking stack:1 for space");
				if(top1!=stack1.length) {
					push1(item);
				} else {
					System.out.println("Stack:1 is also full. So, it can't be inserted");
				}
			}
		} else {
			stack2[++top2]=item;
			System.out.println("Item "+item+" has inserted stack:2 at index - "+top2);
		}
	}
	
	public static void pop2() {
		if(top2==-1) {
			System.out.println("There is no element to pop at stack:2");
		} else {
			System.out.println("Element "+stack2[--top2]+" has been popped out");
		}
	}

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int input = 0;

		while (true) {
			System.out.println("\n1-case:1\t2-case:2\t0-Exit");
			input = ob.nextInt();
			if (input == 1) {
				caseNumber = 1;
				stack1 = new int[arr.length / 2];
				stack2 = new int[arr.length - arr.length / 2];
				for (int i = 0; i < arr.length;) {
					System.out.println("\n1-push\t2-pop\t0-Exit");
					input = ob.nextInt();
					if (input == 1) {
						int item = arr[i++];
						System.out.println("\n1-Stack1\t2-Stack2");
						input = ob.nextInt();
						if (input == 1) {
							push1(item);
						} else {
							push2(item);
						}
					} else if (input == 2) {
						System.out.println("\n1-Stack1\t2-Stack2 to pop");
						input = ob.nextInt();
						if (input == 1) {
							pop1();
						} else {
							pop2();
						}
					} else if (input == 0) {
						break;
					} else {
						System.out.println("Check your input again!!!");
					}
				}
			} else if (input == 2) {
				caseNumber = 2;
				stack1 = new int[arr.length / 2];
				stack2 = new int[arr.length - arr.length / 2];
				for (int i = 0; i < arr.length;) {
					System.out.println("\n1-push\t2-pop\t0-Exit");
					input = ob.nextInt();
					if (input == 1) {
						int item = arr[i++];
						System.out.println("\n1-Stack1\t2-Stack2");
						input = ob.nextInt();
						if (input == 1) {
							push1(item);
						} else {
							push2(item);
						}
					} else if (input == 2) {
						System.out.println("\n1-Stack1\t2-Stack2 to pop");
						input = ob.nextInt();
						if (input == 1) {
							pop1();
						} else {
							pop2();
						}
					} else if (input == 0) {
						break;
					} else {
						System.out.println("Check your input again!!!");
					}
				}
			} else if (input == 0) {
				break;
			} else {
				caseNumber = 0;
				System.out.println("Check your input again!!!");
			}
		}
		System.out.println("Program terminated successfully...");
	}

}
