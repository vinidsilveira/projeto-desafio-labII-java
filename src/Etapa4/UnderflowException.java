package Etapa4;

/**
 * Exceção lançada quando ocorre tentativa de remoção em estrutura vazia.
 */
public class UnderflowException extends Exception {

	public UnderflowException(String message) {
		super(message);
	}
}
