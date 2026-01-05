package Etapa2;

// Métodos de ordenação e pesquisa sobre vetores de Candidato. As ordenações abaixo usam Insertion Sort (estável), útil para discutir estabilidade.
 
public class OrdenarCandidatos {

	// Ordenações 

	// Ordena por nome (ordem alfabética, crescente) – estável
	public static void ordenaCandidatosPorNome(Candidato[] v) {
		for (int i = 1; i < v.length; i++) {
			Candidato key = v[i];
			int j = i - 1;
			while (j >= 0 && compararNome(v[j], key) > 0) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = key;
		}
	}

	// Ordena por votos (decrescente: mais votos primeiro) – estável
	public static void ordenaCandidatosPorVotos(Candidato[] v) {
		for (int i = 1; i < v.length; i++) {
			Candidato key = v[i];
			int j = i - 1;
			while (j >= 0 && v[j].getIntencoesVotos() < key.getIntencoesVotos()) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = key;
		}
	}

	// Ordena por partido (ordem alfabética, crescente) – estável
	public static void ordenaCandidatosPorPartido(Candidato[] v) {
		for (int i = 1; i < v.length; i++) {
			Candidato key = v[i];
			int j = i - 1;
			while (j >= 0 && compararPartido(v[j], key) > 0) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = key;
		}
	}

	// Pesquisa binária por nome

	// Pesquisa binária por nome em vetor já ordenado por nome. Retorna o índice do candidato, ou -1 se não encontrado.
	 
	public static int pesquisaBinariaCandidatos(Candidato[] v, String nomeBuscado) {
		int l = 0, r = v.length - 1;
		while (l <= r) {
			int m = (l + r) >>> 1;
			int cmp = compararString(v[m].getNome(), nomeBuscado);
			if (cmp == 0)
				return m;
			if (cmp < 0)
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}

	// Rotinas auxiliares de comparação (case-insensitive)

	private static int compararNome(Candidato a, Candidato b) {
		return compararString(a.getNome(), b.getNome());
	}

	private static int compararPartido(Candidato a, Candidato b) {
		return compararString(a.getPartido(), b.getPartido());
	}

	// Comparação de String ignorando maiúsculas/minúsculas; nulos vão ao fim
	private static int compararString(String s1, String s2) {
		if (s1 == null && s2 == null)
			return 0;
		if (s1 == null)
			return 1;
		if (s2 == null)
			return -1;
		return s1.compareToIgnoreCase(s2);
	}
}
