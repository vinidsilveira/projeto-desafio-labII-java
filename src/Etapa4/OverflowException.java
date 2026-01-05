package Etapa4;

/**
 * Exceção lançada quando ocorre tentativa de inserção em estrutura cheia. No
 * caso das estruturas dinâmicas, é definida por requisito de interface.
 */
public class OverflowException extends Exception {

	public OverflowException(String message) {
		super(message);
	}
}
