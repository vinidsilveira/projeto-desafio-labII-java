package Etapa4;

public interface Queue<E> {

	boolean isEmpty();

	boolean isFull();

	void enqueue(E element) throws OverflowException;

	E dequeue() throws UnderflowException;

	E front() throws UnderflowException;

	E back() throws UnderflowException;

	int numElements();
}
