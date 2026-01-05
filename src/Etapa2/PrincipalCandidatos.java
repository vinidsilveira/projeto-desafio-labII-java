package Etapa2;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Cria e manipula um vetor de Candidato. Executa as ordenações por partido,
 * votos e nome. Realiza pesquisa binária pelo nome informado pelo usuário.
 */
public class PrincipalCandidatos {

	// Nomes obtidos do arquivo nomes.txt
	private static final String[] NOMES_BASE = { "Lucas", "Jorge", "Beatriz", "Giovana", "Mariana", "Gabriela",
			"Alexandre", "Rafael", "Amanda", "Paulo" };

	private static final String[] PARTIDOS_BASE = { "PDT", "PL", "PT", "PSDB", "MDB", "PSD", "NOVO", "PSOL", "REDE",
			"UNIÃO" };

	public static void main(String[] args) {
		Random rnd = new Random();

		// Cria o vetor com tamanho aleatório entre 1 e 100
		int n = 1 + rnd.nextInt(100);
		Candidato[] candidatos = new Candidato[n];

		// Preenche o vetor com dados aleatórios
		for (int i = 0; i < n; i++) {
			String nome = NOMES_BASE[rnd.nextInt(NOMES_BASE.length)];
			String partido = PARTIDOS_BASE[rnd.nextInt(PARTIDOS_BASE.length)];
			int votos = rnd.nextInt(10001); // 0 a 10.000 intenções
			candidatos[i] = new Candidato(nome, partido, votos);
		}

		System.out.println("Vetor gerado (" + n + " candidatos):");
		System.out.println(Arrays.toString(candidatos));

		// Ordenações na ordem mostrada no diagrama de sequência
		OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
		OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
		OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);

		System.out.println("\nVetor ordenado (partido, votos, nome):");
		System.out.println(Arrays.toString(candidatos));

		// Pesquisa binária pelo nome informado pelo usuário
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("\nInforme o nome do candidato para pesquisar: ");
			String nomeBuscado = sc.nextLine();

			int idx = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomeBuscado);

			if (idx >= 0) {
				System.out.println("\nCandidato encontrado:");
				System.out.println(candidatos[idx]);
			} else {
				System.out.println("\nNenhum candidato com o nome informado foi encontrado.");
			}
		}
	}
}
