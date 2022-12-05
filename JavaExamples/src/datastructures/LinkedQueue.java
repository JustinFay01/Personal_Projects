package datastructures;

public class LinkedQueue<E> {
	private Node<E> front;
	private Node<E> rear;
	private int size;

	public LinkedQueue() {
		front = rear = null;
		size = 0;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int getSize() {
		return size;
	}

	public void enqueue(E newVal) {
		Node<E> newNode = new Node(newVal);
		if (size == 0) {
			front = newNode;
			rear = newNode;
			size++;
		} else if (size == 1) {
			rear = front;
			rear.setNext(newNode);
			rear = newNode;
			size++;
		} else if (size > 1) {
			rear.setNext(newNode);
			rear = newNode;
			size++;
		}
	}

	public E dequeue() throws EmptyQueueException {
		E removed;
		if (front == null) {
			throw new EmptyQueueException();
		} else {
			removed = front.getValue();
			if (size == 1) {
				front = null;
				rear = null;
			} else {
				front = front.getNext();
			}
			size--;
		}
		return removed;
	}

	public E peek() throws EmptyQueueException {
		E removed;
		if (front == null) {
			throw new EmptyQueueException();
		} else {
			removed = front.getValue();
		}
		return removed;
	}

	public String toString() {
		String str = "";
		if (size == 0) {
			return str;
		} else {
			Node<E> curr = front;
			while (curr.getNext() != null) {
				str = curr.getValue() + " ";
				curr = curr.getNext();
			}
		}
		return str;
	}

}
