package datastructures;

public class Node<E> {
	
	private E value;
	private Node<E> next;
	
	public Node(E val) {
		value = val;
	}
	
	public Node(E val, Node<E> next) {
		value = val;
		this.next = next;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public E getValue() {
		return value;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public void setValue(E value) {
		this.value = value;
	}

}
