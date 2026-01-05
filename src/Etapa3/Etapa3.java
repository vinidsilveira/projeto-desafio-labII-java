package Etapa3;

/**
 * Verificação de agrupamento de parênteses usando pilha. Suporta tanto
 * Stack<Character> quanto StaticStack<Character>.
 */
public class Etapa3 {

	// --- Assinatura provável usada pelo validador (via interface) ---
	public static boolean checkBrackets(Stack<Character> s1) {
		return checkBracketsCore(s1);
	}

	// --- Assinatura alternativa (caso o validador passe StaticStack) ---
	public static boolean checkBrackets(StaticStack<Character> s1) {
		return checkBracketsCore(s1);
	}

	// Núcleo comum da verificação
	private static boolean checkBracketsCore(Stack<Character> s1) {
		// pilha auxiliar para parear fechamentos
		StaticStack<Character> aux = new StaticStack<>(s1.numElements());

		while (!s1.isEmpty()) {
			char c = s1.pop();
			if (c == ')') {
				aux.push(c);
			} else if (c == '(') {
				if (aux.isEmpty()) {
					return false; // não há fechador correspondente
				}
				aux.pop();
			}
			// demais caracteres são ignorados
		}
		// válido se não restaram fechadores sem abridor
		return aux.isEmpty();
	}
}
