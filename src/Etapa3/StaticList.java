package Etapa3;

public class StaticList<E> {
	private final Object[] elements;
	private int size = 0;

	public StaticList(int maxSize) {
		if (maxSize <= 0)
			throw new IllegalArgumentException("Capacidade deve ser > 0");
		this.elements = new Object[maxSize];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == elements.length;
	}

	public int numElements() {
		return size;
	}

	public void insert(E element, int index) {
		if (isFull())
			throw new IllegalStateException("Lista cheia");
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		for (int i = size; i > index; i--)
			elements[i] = elements[i - 1];
		elements[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return (E) elements[index];
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (isEmpty())
			throw new IllegalStateException("Lista vazia");
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		E old = (E) elements[index];
		for (int i = index; i < size - 1; i++)
			elements[i] = elements[i + 1];
		elements[size - 1] = null;
		size--;
		return old;
	}

	// ====== REQUISITO DO VALIDADOR ======
	
	// Método contaElemntos
	public int contaElementos(E el) {
		return contaElementosRecursivo(el, 0);
	}

	// Método contaElementosRecursivo
	private int contaElementosRecursivo(E el, int i) {
		if (i >= size)
			return 0;
		boolean match = (el == null) ? (elements[i] == null) : el.equals(elements[i]);
		return (match ? 1 : 0) + contaElementosRecursivo(el, i + 1);
	}
	
	// =====================================

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			sb.append(elements[i]);
			if (i < size - 1)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
