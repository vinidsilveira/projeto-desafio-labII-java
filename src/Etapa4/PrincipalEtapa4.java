package Etapa4;

/**
 * Classe principal da Etapa 4. Demonstra o uso da pilha e fila dinâmicas.
 */

public class PrincipalEtapa4 {

	public static void main(String[] args) {
		try {
			// ===== Teste da Pilha Dinâmica =====
			System.out.println("=== Teste da Pilha Dinâmica (LinkedStack) ===");
			LinkedStack<Integer> pilha = new LinkedStack<>();

			pilha.push(10);
			pilha.push(20);
			pilha.push(30);

			System.out.println("Topo da pilha: " + pilha.top());
			System.out.println("Desempilhando: " + pilha.pop());
			System.out.println("Novo topo: " + pilha.top());
			System.out.println("Quantidade de elementos: " + pilha.numElements());

			// ===== Teste da Fila Dinâmica =====
			System.out.println("\n=== Teste da Fila Dinâmica (LinkedQueue) ===");
			LinkedQueue<String> fila = new LinkedQueue<>();

			fila.enqueue("A");
			fila.enqueue("B");
			fila.enqueue("C");

			System.out.println("Primeiro da fila: " + fila.front());
			System.out.println("Último da fila: " + fila.back());
			System.out.println("Desenfileirando: " + fila.dequeue());
			System.out.println("Novo primeiro: " + fila.front());
			System.out.println("Quantidade de elementos: " + fila.numElements());

		} catch (OverflowException | UnderflowException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
