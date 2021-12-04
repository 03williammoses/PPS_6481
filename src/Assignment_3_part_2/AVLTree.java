package Assignment_3_part_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
	int key;
	String value;
	int h;
	Node leftChild;
	Node rightChild;

	public Node() {
		leftChild = null;
		rightChild = null;
		key = 0;
		value = "NA";
		h = 0;
	}

	public Node(int key) {
		leftChild = null;
		rightChild = null;
		this.key = key;
		this.value = "ABC School";
		h = 0;
	}
}

public class AVLTree extends CleverSIDC {
	private Node rootNode;

	// Constructor to set null value to the rootNode
	public AVLTree(int totalNumberOfStudents) {
		super(totalNumberOfStudents);
		rootNode = null;
	}

	public void setSIDCThreshold(int Size) {
		this.totalNumberOfStudents = Size;
	}

	public void generate() {
		
	}

	public List<Integer> allKeys(CleverSIDC ob) {
		return inorderTraversal();
	}

	@Override
	public void add(CleverSIDC ob, int key, String value) {
		insertElement(key);
	}

	@Override
	public String remove(CleverSIDC ob, int key) {
		return null;
	}

	@Override
	public String getValues(CleverSIDC ob, int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextKey(CleverSIDC ob, int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int prevKey(CleverSIDC ob, int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> rangeKey(int key1, int key2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAll() {
		rootNode = null;
	}

	public boolean checkEmpty() {
		if (rootNode == null)
			return true;
		else
			return false;
	}

	public void insertElement(int element) {
		rootNode = insertElement(element, rootNode);
	}

	private int getHeight(Node node) {
		return node == null ? -1 : node.h;
	}

	private int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
		return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
	}

	private Node insertElement(int element, Node node) {
		if (node == null)
			node = new Node(element);
		
		else if (element < node.key) {
			node.leftChild = insertElement(element, node.leftChild);
			if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2)
				if (element < node.leftChild.key)
					node = rotateWithLeftChild(node);
				else
					node = doubleWithLeftChild(node);
		} else if (element > node.key) {
			node.rightChild = insertElement(element, node.rightChild);
			if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2)
				if (element > node.rightChild.key)
					node = rotateWithRightChild(node);
				else
					node = doubleWithRightChild(node);
		} else
			; 
		node.h = getMaxHeight(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

		return node;

	}

	private Node rotateWithLeftChild(Node node2) {
		Node node1 = node2.leftChild;
		node2.leftChild = node1.rightChild;
		node1.rightChild = node2;
		node2.h = getMaxHeight(getHeight(node2.leftChild), getHeight(node2.rightChild)) + 1;
		node1.h = getMaxHeight(getHeight(node1.leftChild), node2.h) + 1;
		return node1;
	}

	private Node rotateWithRightChild(Node node1) {
		Node node2 = node1.rightChild;
		node1.rightChild = node2.leftChild;
		node2.leftChild = node1;
		node1.h = getMaxHeight(getHeight(node1.leftChild), getHeight(node1.rightChild)) + 1;
		node2.h = getMaxHeight(getHeight(node2.rightChild), node1.h) + 1;
		return node2;
	}

	private Node doubleWithLeftChild(Node node3) {
		node3.leftChild = rotateWithRightChild(node3.leftChild);
		return rotateWithLeftChild(node3);
	}
	
	private Node doubleWithRightChild(Node node1) {
		node1.rightChild = rotateWithLeftChild(node1.rightChild);
		return rotateWithRightChild(node1);
	}

	public int getTotalNumberOfNodes() {
		return getTotalNumberOfNodes(rootNode);
	}

	private int getTotalNumberOfNodes(Node head) {
		if (head == null)
			return 0;
		else {
			int length = 1;
			length = length + getTotalNumberOfNodes(head.leftChild);
			length = length + getTotalNumberOfNodes(head.rightChild);
			return length;
		}
	}

	public boolean searchElement(int element) {
		return searchElement(rootNode, element);
	}

	private boolean searchElement(Node head, int element) {
		boolean check = false;
		while ((head != null) && !check) {
			int headElement = head.key;
			if (element < headElement)
				head = head.leftChild;
			else if (element > headElement)
				head = head.rightChild;
			else {
				check = true;
				break;
			}
			check = searchElement(head, element);
		}
		return check;
	}
	public List<Integer> inorderTraversal() {
		return inorderTraversal(rootNode);
	}

	private List<Integer> inorderTraversal(Node head) {
		Stack<Node> s = new Stack<Node>();
		List<Integer> list = new ArrayList<>();
        Node curr = head;
 
        while (curr != null || s.size() > 0)
        {
            while (curr !=  null)
            {
                s.push(curr);
                curr = curr.leftChild;
            }
            curr = s.pop(); 
            list.add(curr.key);
            curr = curr.rightChild;
        }
		return list;
		
	}

	
}