/*
 * 
 */
package Assignment_3_part_2;

// TODO: Auto-generated Javadoc
class Node {
	long key;
	String value;
	int h;
	Node left;
	Node right;

	public Node() {
		left = null;
		right = null;
		key = 0;
		value = "NA";
		h = 0;
	}

	public Node(long key) {
		left = null;
		right = null;
		this.key = key;
		this.value = "ABC School";
		h = 0;
	}
}

/**
 * The Class AVLTree.
 */
public class AVLTree extends CleverSIDC {

	/** The root. */
	private Node root;

	/** The Stack array. */
	Node StackArray[];

	static long arr[];
	static int index = 0;

	/**
	 * The Class Stack.
	 */
	class Stack {

		/** The top. */
		int top = -1;

		/**
		 * Instantiates a new stack.
		 */
		public Stack() {
			top = -1;
		}

		/**
		 * Push.
		 *
		 * @param data the data
		 */
		public void push(Node data) {
			if (top == StackArray.length) {
				System.out.println("Stack is FULL");
			} else {
				StackArray[++top] = data;
			}
		}

		/**
		 * Pop.
		 *
		 * @return the node
		 */
		public Node pop() {
			if (top == -1) {
				System.out.println("Stack is EMPTY");
				return null;
			} else {
				return StackArray[top--];
			}
		}
	}

	/**
	 * Instantiates a new AVL tree.
	 *
	 * @param totalNumberOfStudents the total number of students
	 */
	public AVLTree(int totalNumberOfStudents) {
		super(totalNumberOfStudents);
		System.out.println("AVL Tree has been loaded");
		StackArray = new Node[this.totalNumberOfStudents];
		arr = new long[this.totalNumberOfStudents];
		root = null;
	}

	/**
	 * Sets the SIDC threshold.
	 *
	 * @param Size the new SIDC threshold
	 */
	public void setSIDCThreshold(int Size) {
		this.totalNumberOfStudents = Size;
	}

	/**
	 * Checks if is exists.
	 *
	 * @param cleverSIDC the clever SIDC
	 * @param num        the num
	 * @return true, if is exists
	 */
	public boolean isExists(CleverSIDC cleverSIDC, int num) {
		Stack s = new Stack();
		Node curr = root;
		while (curr != null || s.top > -1) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if (curr.key == num) {
				return true;
			}
			curr = curr.right;
		}
		return false;
	}

	/**
	 * Generate.
	 *
	 * @return the int
	 */
	public int generate() {
		int max = 99999999;
		int min = 10000000;
		int range = max - min + 1;
		boolean exists = false;
		int number = 1;
		while (!exists) {
			number = (int) (Math.random() * range) + min;
			exists = isExists(this, number);
		}
		return number;
	}

	/**
	 * All keys.
	 *
	 * @param ob the ob
	 * @return the string
	 */
	public long[] allKeys(CleverSIDC ob) {
		return inOrderKeys();
	}

	/**
	 * Adds the.
	 *
	 * @param ob    the ob
	 * @param key   the key
	 * @param value the value
	 */
	@Override
	public void add(CleverSIDC ob, long key, String value) {
		insert(key);
	}

	/**
	 * Removes the.
	 *
	 * @param ob  the ob
	 * @param key the key
	 * @return the string
	 */
	@Override
	public String remove(CleverSIDC ob, long key) {
		return delete(key);
	}

	/**
	 * Gets the values.
	 *
	 * @param ob  the ob
	 * @param key the key
	 * @return the values
	 */
	@Override
	public String getValues(CleverSIDC ob, long key) {
		return getValue(key);
	}

	/**
	 * Next key.
	 *
	 * @param ob  the ob
	 * @param key the key
	 * @return the long
	 */
	@Override
	public long nextKey(CleverSIDC ob, long key) {
		return getNextKey(key);
	}

	/**
	 * Prev key.
	 *
	 * @param ob  the ob
	 * @param key the key
	 * @return the long
	 */
	@Override
	public long prevKey(CleverSIDC ob, long key) {
		return getPrevKey(key);
	}

	/**
	 * Range key.
	 *
	 * @param key1 the key 1
	 * @param key2 the key 2
	 * @return the long[]
	 */
	@Override
	public long[] rangeKey(long key1, long key2) {
		return getRangeKey(key1, key2);
	}

	/**
	 * Height.
	 *
	 * @param N the n
	 * @return the int
	 */
	int height(Node N) {
		if (N == null)
			return 0;
		return N.h;
	}

	/**
	 * Max.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the int
	 */
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * Right rotate.
	 *
	 * @param y the y
	 * @return the node
	 */
	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.h = max(height(y.left), height(y.right)) + 1;
		x.h = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	/**
	 * Left rotate.
	 *
	 * @param x the x
	 * @return the node
	 */
	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.h = max(height(x.left), height(x.right)) + 1;
		y.h = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	/**
	 * Gets the balance.
	 *
	 * @param N the n
	 * @return the balance
	 */
	int getBalance(Node N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	/**
	 * Insert.
	 *
	 * @param key the key
	 * @return the node
	 */
	public Node insert(long key) {
		this.root = insert(root, key);
		return root;
	}

	/**
	 * Insert.
	 *
	 * @param node the node
	 * @param key  the key
	 * @return the node
	 */
	Node insert(Node node, long key) {
		if (node == null)
			return (new Node(key));

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else
			return node;
		node.h = 1 + max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	/**
	 * Min value node.
	 *
	 * @param node the node
	 * @return the node
	 */
	Node minValueNode(Node node) {
		Node current = node;

		while (current.left != null)
			current = current.left;

		return current;
	}

	/**
	 * Delete.
	 *
	 * @param key the key
	 * @return the string
	 */
	public String delete(long key) {
		return deleteNode(root, key) != null ? "Key " + key + " removed successfully" : "Key not found";
	}

	/**
	 * Delete node.
	 *
	 * @param root the root
	 * @param key  the key
	 * @return the node
	 */
	Node deleteNode(Node root, long key) {
		if (root == null)
			return root;
		if (key < root.key)
			root.left = deleteNode(root.left, key);
		else if (key > root.key)
			root.right = deleteNode(root.right, key);
		else {
			if ((root.left == null) || (root.right == null)) {
				Node temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {

				Node temp = minValueNode(root.right);

				root.key = temp.key;

				root.right = deleteNode(root.right, temp.key);
			}
		}

		if (root == null)
			return root;

		root.h = max(height(root.left), height(root.right)) + 1;

		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.left) >= 0)
			return rightRotate(root);

		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if (balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	/**
	 * Gets the range key.
	 *
	 * @param r1 the r 1
	 * @param r2 the r 2
	 * @return the range key
	 */
	public long[] getRangeKey(long r1, long r2) {
		return getRangeKey(root, r1, r2);
	}

	/**
	 * Gets the range key.
	 *
	 * @param head the head
	 * @param r1   the r 1
	 * @param r2   the r 2
	 * @return the range key
	 */
	private long[] getRangeKey(Node head, long r1, long r2) {
		Node curr = head;
		Stack s = new Stack();
		long[] listArray = new long[this.totalNumberOfStudents];
		int index = 0;
		while (curr != null || s.top > -1) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if (curr.key == r1) {
				listArray[index++] = curr.key;
			} else if (index != 0) {
				listArray[index++] = curr.key;
			}
			if (curr.key == r2) {
				return listArray;
			}
			curr = curr.right;
		}
		return listArray;
	}

	/**
	 * Gets the prev key.
	 *
	 * @param key the key
	 * @return the prev key
	 */
	public long getPrevKey(long key) {
		return getPrevKey(root, key);
	}

	/**
	 * Gets the prev key.
	 *
	 * @param head the head
	 * @param key  the key
	 * @return the prev key
	 */
	private long getPrevKey(Node head, long key) {
		Node curr = head;
		Stack s = new Stack();
		long temp = curr.key;
		while (curr != null || s.top > -1) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if (curr.key == key) {
				return temp;
			} else {
				temp = curr.key;
			}
			curr = curr.right;
		}
		return temp;
	}

	/**
	 * Gets the next key.
	 *
	 * @param key the key
	 * @return the next key
	 */
	public long getNextKey(long key) {
		return getNextKey(root, key);
	}

	/**
	 * Gets the next key.
	 *
	 * @param head the head
	 * @param key  the key
	 * @return the next key
	 */
	private long getNextKey(Node head, long key) {
		Node curr = head;
		Stack s = new Stack();
		long temp = curr.key;
		while (curr != null || s.top > -1) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if (temp == key) {
				return curr.key;
			} else {
				temp = curr.key;
			}
			curr = curr.right;
		}
		return temp;
	}

	/**
	 * Gets the value.
	 *
	 * @param key the key
	 * @return the value
	 */
	public String getValue(long key) {
		return getValue(root, key);
	}

	/**
	 * Gets the value.
	 *
	 * @param head the head
	 * @param key  the key
	 * @return the value
	 */
	private String getValue(Node head, long key) {
		Node curr = head;
		Stack s = new Stack();

		while (curr != null || s.top > -1) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if (curr.key == key) {
				return curr.value;
			}
			curr = curr.right;
		}
		return "Not found";
	}

	/**
	 * In order keys.
	 *
	 * @return the string
	 */
	public long[] inOrderKeys() {
		arr = new long[this.totalNumberOfStudents];
		index = 0;
		long start = System.currentTimeMillis();
		inorder(root);
		long end = System.currentTimeMillis();
		System.out.println("Time took to sort allKeys():" + (end - start) + "ms");
		return arr;
	}

	/**
	 * In order keys.
	 *
	 * @param head the head
	 * @return the string
	 */
	void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		arr[index++] = node.key;
		inorder(node.right);
	}

	

}