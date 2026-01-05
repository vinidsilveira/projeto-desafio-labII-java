package Etapa1;

public class PrincipalLabirinto {

	public static void main(String[] args) {
		try {
			Labirinto lab = new Labirinto();

			lab.criaLabirinto("src/Etapa1/labirinto.txt");

			System.out.println("Labirinto inicial:");
			lab.imprimeLabirinto();

			boolean encontrou = lab.percorreLabirinto();

			System.out.println("\nResultado:");
			if (encontrou) {
				System.out.println("Solução encontrada. Caminho indicado com '#'.");
			} else {
				System.out.println("Nenhum caminho até a saída foi encontrado.\n");
			}

			lab.imprimeLabirinto();

		} catch (Exception e) {
			System.out.println("Erro durante a execução: " + e.getMessage());
		}
	}
}
