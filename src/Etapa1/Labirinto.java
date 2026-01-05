package Etapa1;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {
	private static final char PAREDE = 'X';
	private static final char CAMINHO_ABERTO = ' ';
	private static final char SAIDA = 'D';
	private static final char CAMINHO_SOLUCAO = '#';

	private char[][] labirinto;

	public void criaLabirinto(String filename) {
		try {
			// Resolve o caminho
			Path p = Path.of(filename);
			if (!Files.exists(p)) {
				Path p1 = Path.of("src", filename);
				Path p2 = Path.of("src", "Etapa1", filename);
				if (Files.exists(p1))
					p = p1;
				else if (Files.exists(p2))
					p = p2;
			}

			// Leitura preservando espaços
			List<String> linhas = new ArrayList<>();
			try (BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
				String line;
				while ((line = br.readLine()) != null) {
					linhas.add(line); // sem trim()
				}
			}

			if (linhas.isEmpty()) {
				// considere vazio como erro de conteúdo
				throw new IllegalArgumentException("Arquivo vazio: " + filename);
			}

			int rows = linhas.size();
			int cols = 0;
			for (String s : linhas)
				cols = Math.max(cols, s.length());

			char[][] m = new char[rows][cols];
			for (int i = 0; i < rows; i++) {
				String s = linhas.get(i);
				for (int j = 0; j < cols; j++) {
					char c = (j < s.length()) ? s.charAt(j) : CAMINHO_ABERTO;
					m[i][j] = c;
				}
			}
			this.labirinto = m;

		} catch (Exception e) {
			// EXIGÊNCIA DO VALIDADOR: capturar e RELANÇAR como IllegalArgumentException
			throw new IllegalArgumentException("Falha ao ler o arquivo do labirinto: " + filename, e);
		}
	}

	public boolean percorreLabirinto() {
		if (labirinto == null || labirinto.length == 0)
			return false;
		if (!posicaoCaminhavelOuSaida(0, 0))
			return false;
		boolean[][] visitado = new boolean[labirinto.length][labirinto[0].length];
		return resolverLabirinto(0, 0, visitado);
	}

	private boolean resolverLabirinto(int x, int y, boolean[][] visitado) {
		if (!dentro(x, y))
			return false;
		if (labirinto[x][y] == PAREDE)
			return false;
		if (visitado[x][y])
			return false;
		if (labirinto[x][y] == SAIDA)
			return true;

		visitado[x][y] = true;
		char original = labirinto[x][y];
		if (original == CAMINHO_ABERTO)
			labirinto[x][y] = CAMINHO_SOLUCAO;

		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int[] d : dirs) {
			if (resolverLabirinto(x + d[0], y + d[1], visitado))
				return true;
		}

		if (original == CAMINHO_ABERTO)
			labirinto[x][y] = CAMINHO_ABERTO;
		return false;
	}

	private boolean dentro(int x, int y) {
		return x >= 0 && x < labirinto.length && y >= 0 && y < labirinto[0].length;
	}

	private boolean posicaoCaminhavelOuSaida(int x, int y) {
		char c = labirinto[x][y];
		return c == CAMINHO_ABERTO || c == SAIDA;
	}

	public void imprimeLabirinto() {
		if (labirinto == null) {
			System.out.println("(labirinto não carregado)");
			return;
		}
		for (char[] linha : labirinto)
			System.out.println(new String(linha));
	}
}
