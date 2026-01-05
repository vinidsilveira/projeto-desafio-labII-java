package Etapa4;

/**
 * Implementação de pilha dinâmica (encadeada) usando nós.
 */
public class LinkedStack<E> implements Stack<E> {

	private Node<E> top;
	private int count;

	public LinkedStack() {
		this.top = null;
		this.count = 0;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public boolean isFull() {
		// Estrutura dinâmica: considera-se que não fica cheia
		return false;
	}

	@Override
	public void push(E element) throws OverflowException {
		if (isFull()) {
			throw new OverflowException("Pilha cheia");
		}
		Node<E> novo = new Node<>(element);
		novo.setNext(top);
		top = novo;
		count++;
	}

	@Override
	public E pop() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException("Pilha vazia");
		}
		E elem = top.getElement();
		top = top.getNext();
		count--;
		return elem;
	}

	@Override
	public E top() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException("Pilha vazia");
		}
		return top.getElement();
	}

	@Override
	public int numElements() {
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> aux = top;
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
