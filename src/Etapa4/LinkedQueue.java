package Etapa4;

// Implementação de fila dinâmica (encadeada) usando nós.
 
public class LinkedQueue<E> implements Queue<E> {

	private Node<E> front;
	private Node<E> rear;
	private int count;

	public LinkedQueue() {
		this.front = null;
		this.rear = null;
		this.count = 0;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void enqueue(E element) throws OverflowException {
		if (isFull()) {
			throw new OverflowException("Fila cheia");
		}

		Node<E> novo = new Node<>(element);

		if (isEmpty()) {
			front = novo;
			rear = novo;
		} else {
			rear.setNext(novo);
			rear = novo;
		}
		count++;
	}

	@Override
	public E dequeue() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException("Fila vazia");
		}

		E elem = front.getElement();
		front = front.getNext();
		if (front == null) {
			rear = null;
		}
		count--;
		return elem;
	}

	@Override
	public E front() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException("Fila vazia");
		}
		return front.getElement();
	}

	// Método first
	public E first() throws UnderflowException {
		return front();
	}

	@Override
	public E back() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException("Fila vazia");
		}
		return rear.getElement();
	}

	@Override
	public int numElements() {
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> aux = front;
		while (aux != null) {
			sb.append(aux.getElement());
			aux = aux.getNext();
			if (aux != null) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
