package LabExercise.Lab9;

import java.util.Scanner;

class BST {
	Node root;

	class Node {
		int value;
		Node left, right;

		public Node() {
			value = 0;
			left = right = null;
		}

		public Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	public void insert(int value) {
		insert(root, value);
	}

	public void insert(Node root, int value) {
		if (root == null) {
			this.root = new Node(value);
			return;
		}
		Node temp = root;
		while (temp.left != null || temp.right != null) {
			if (temp.left!=null && value < temp.value) {
				temp = temp.left;
			} else if(temp.right!=null && value > temp.value){
				temp = temp.right;
			} else {
				break;
			}
		}
		if (value < temp.value) {
			temp.left = new Node(value);
		} else {
			temp.right = new Node(value);
		}
	}
	

	public int parentOf(int value) {
		return parentOf(root, value);
	}

	public int parentOf(Node root, int value) {
		Node temp = root;
		boolean found = false;
		if(root.value==value) {
			return 0;
		}
		while (temp.left != null || temp.right != null) {
			if ((temp.left != null && temp.left.value == value) || (temp.right != null && temp.right.value == value)) {
				found = true;
				break;
			}
			if (value < temp.value && temp.left != null) {
				temp = temp.left;
			} else if (temp.right != null) {
				temp = temp.right;
			} else {
				break;
			}
		}
		return found ? temp.value : -1;
	}
}

public class UseBST {

	public static void main(String[] args) {

		BST b1 = new BST();

		System.out.println("Enter a value to add to the tree or -1 to terminate: ");
		int v, y;
		Scanner kb = new Scanner(System.in);

		v = kb.nextInt();
		while (v != -1) {
			b1.insert(v);

			v = kb.nextInt();
		}

		System.out.println("Tree creation is done.");

		System.out.println("Enter the values you want to search for ending by -1 to terminate: ");
		v = kb.nextInt();
		while (v != -1) {
			y = b1.parentOf(v);
			if (y == -1)
				System.out.println("Value " + v + " does not exist in tree.");
			else if (y == 0)
				System.out.println("Value " + v + " is tree root.");
			else
				System.out.println("Parent of " + v + " is " + y);
			v = kb.nextInt();
		}

	}

}
