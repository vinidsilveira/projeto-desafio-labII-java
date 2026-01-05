package Etapa3;

public interface Stack<E> {

    boolean isEmpty();

    boolean isFull();

    int numElements();

    void push(E element);

    E pop();

    E top();
}
