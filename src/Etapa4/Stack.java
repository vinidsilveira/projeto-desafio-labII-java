package Etapa4;

public interface Stack<E> {

	boolean isEmpty();

	boolean isFull();

	void push(E element) throws OverflowException;

	E pop() throws UnderflowException;

	E top() throws UnderflowException;

	int numElements();
}
