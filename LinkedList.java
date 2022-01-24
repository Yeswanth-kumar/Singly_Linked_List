public class LinkedList<T> {
	Node head;

	class Node {
		T data;
		Node next;

		Node(T val) {
			data = val;
			next = null;
		}
	}

	LinkedList() {
		head = null;
	}

	public void prepend(T value) {
		Node newnode = new Node(value);
		if (head == null) {
			head = newnode;
		} else {
			newnode.next = head;
			head = newnode;
		}
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void add(int pos, T value) {
		if (pos == 0) {
			append(value);
			return;
		}
		Node newnode = new Node(value);
		Node temp = head;
		for (int i = 1; i < pos; i++) {
			temp = temp.next;
			if (temp == null) {
				throw new IndexOutOfBoundsException("Invalid Position : " + pos);
			}
		}
		newnode.next = temp.next;
		temp.next = newnode;
	}

	public void remove(int pos) {
		if (head == null) {
			throw new IndexOutOfBoundsException("List is Empty");
		}
		Node temp = head;
		Node pre = null;
		if (pos == 0) {
			removeAtBeginning();
			return;
		}
		for (int i = 1; i <= pos; i++) {
			pre = temp;
			temp = temp.next;
			if (temp == null) {
				throw new IllegalArgumentException("Invalid Position : " + pos);
			}
		}
		pre.next = temp.next;
	}

	public void removeAtBeginning() {
		if (head == null) {
			throw new IllegalArgumentException("Invalid Position : ");
		}
		head = head.next;
	}

	public void get(int pos) {
		empty();
		Node temp = head;
		for (int i = 1; i <= pos; i++) {
			temp = temp.next;
			outOfRange(temp, pos);
		}
		System.out.println(temp.data);
	}

	public void update(int pos, T val) {
		empty();
		Node temp = head;
		if(pos == 0) {
			temp.data = val;
		}
		for(int i = 1; i <= pos; i++) {
			temp = temp.next;
			outOfRange(temp, pos);
		}
		temp.data =  val;
	}

	
	public void append(T val) {
		empty();
		Node temp = head;
		Node pre = null;
		Node newnode = new Node(val);
		while(temp != null) {
			pre = temp;
			temp = temp.next;
		}
		temp = newnode;
		pre.next = temp;
	}
	
	public void search(T value) {
		int index = 0;
		Node temp = head;
		while(temp != null) {
			if(temp.data == value) {
				System.out.println(index);
			}
			temp = temp.next;
			index++;
		}
	}
	
	public void contains(T val) {
		Node temp = head;
		while(temp != null) {
			if(temp.data == val) {
				System.out.println(true);
				return;
			}
			temp = temp.next;
		}
		System.out.println(false);
	}


	void empty() {
		if (head == null) {
			throw new IndexOutOfBoundsException("List is Empty");
		}
	}

	void outOfRange(Node node, int pos) {
		if (node == null) {
			throw new IndexOutOfBoundsException("Invalid Position : " + pos);
		}
	}
}
