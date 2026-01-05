package Etapa3;

/**
 * Classe principal da Etapa 3. Executa dois testes: contagem recursiva em lista
 * e verificação de agrupamento de parênteses usando pilha estática.
 */
public class PrincipalEtapa3 {

	public static void main(String[] args) {

		// ---------- Teste 1: Lista Estática e Recursão ----------
		System.out.println("===== Teste da Lista Estática =====");
		StaticList<Integer> lista = new StaticList<>(10);

		lista.insert(10, 0);
		lista.insert(20, 1);
		lista.insert(10, 2);
		lista.insert(30, 3);
		lista.insert(10, 4);

		System.out.println("Conteúdo da lista: " + lista);
		int valorProcurado = 10;
		int qtd = lista.contaElementos(valorProcurado);
		System.out.println("O elemento " + valorProcurado + " aparece " + qtd + " vez(es).");

		// ---------- Teste 2: Pilha Estática e Verificação de Parênteses ----------
		System.out.println("\n===== Teste da Pilha Estática =====");
		String expressao = "((A+B)-(C+D))";
		StaticStack<Character> pilha = new StaticStack<>(expressao.length());

		// empilha os caracteres da expressão
		for (int i = 0; i < expressao.length(); i++) {
			pilha.push(expressao.charAt(i));
		}

		System.out.println("Expressão: " + expressao);
		boolean agrupamentoCorreto = Etapa3.checkBrackets(pilha);
		System.out.println("Agrupamento correto: " + agrupamentoCorreto);
	}
}
