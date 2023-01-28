package datastructures;

import java.util.EmptyStackException;

public class LinkedStack<E> {

	private Node<E> top;
	private int size;

	public LinkedStack() {
		top = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(E val) {
		Node<E> newNode = null;
		if (top == null) {
			newNode = new Node<>(val);
		} else {
			newNode = new Node<>(val, top);
		}
		top = newNode;
		size++;

	}

	public E pop() {
		E removed;
		if (top == null) {
			throw new EmptyStackException();
		} else {
			removed = top.getValue();

			if (size == 1) {
				top = null;
			} else {
				top = top.getNext();
			}
			size--;
			return removed;
		}
	}

	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return top.getValue();
		}
	}

	public String toString() {
		String stackContents = "";
		Node<E> topCopy = top;
		while (topCopy != null) {
			stackContents += topCopy.getValue() + " ";
			topCopy = topCopy.getNext();
		}
		return stackContents;
	}
}
