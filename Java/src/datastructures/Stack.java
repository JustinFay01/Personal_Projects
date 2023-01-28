package datastructures;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
	private int top;
	private T[] stack;

	public Stack(int capacity) {
		top = 0;
		stack = ((T[]) new Object[capacity]);
	}

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return stack[top - 1];
		}
	}

	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();

		T toBeRemoved = stack[top - 1];
		stack[top - 1] = null;
		top--;
		return toBeRemoved;

	}

	public void push(T newElement) {
		if (top == stack.length) { // Array is full
			stack = Arrays.copyOf(stack, stack.length * 2);
		}
		stack[top] = newElement;
		top++;

	}

	public String toString() {
		String stackContents = "";
		for (int i = 0; i < top; i++) {
			stackContents += stack[i] + " ";
		}
		stackContents += " <--top of the stack";

		return stackContents;
	}
}