package Etapa3;

public class StaticStack<E> implements Stack<E> {
	private final Object[] elements;
	private int top = -1;

	public StaticStack(int maxSize) {
		if (maxSize <= 0)
			throw new IllegalArgumentException("Capacidade deve ser > 0");
		this.elements = new Object[maxSize];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == elements.length - 1;
	}

	@Override
	public int numElements() {
		return top + 1;
	}

	@Override
	public void push(E element) {
		if (isFull())
			throw new IllegalStateException("Pilha cheia");
		elements[++top] = element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		if (isEmpty())
			throw new IllegalStateException("Pilha vazia");
		E e = (E) elements[top];
		elements[top] = null;
		top--;
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E top() {
		if (isEmpty())
			throw new IllegalStateException("Pilha vazia");
		return (E) elements[top];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i <= top; i++) {
			sb.append(elements[i]);
			if (i < top)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
