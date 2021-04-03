package textgen;

import java.util.AbstractList;
import java.util.Objects;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {

	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) {
		Objects.requireNonNull(element);

		LLNode<E> newNode = new LLNode<E>(element, tail.prev, tail);
		tail.prev.next = newNode;
		tail.prev = newNode;
		++size;

		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> ll = head.next;
		LLNode<E> search = ll;
		for(int i = 0; i <= index; i++) {
			search = search.next;
			if(i == index) {
				return search.data;
			}
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		//if(element == null) throw new NullPointerException();
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return -1;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   	
	
	@Override
	public String toString() {
		StringBuilder stringRepresentation = new StringBuilder();
		stringRepresentation.append("[");
		
		int index = 0;

		for (E element : this) {
			if (index++ != size - 1) {
				stringRepresentation.append(element.toString() + ", ");
			} else {
				stringRepresentation.append(element.toString());
			}
		}

		stringRepresentation.append("]");

		return stringRepresentation.toString();
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e, LLNode<E> prev, LLNode<E> next) {
		this.data = e;
		this.prev = prev;
		this.next = next;
	}

}
