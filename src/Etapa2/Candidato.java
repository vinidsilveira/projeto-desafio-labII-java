package Etapa2;

 // Representa um candidato em uma pesquisa. Inclui nome, partido e quantidade de intenções de voto.
 
public class Candidato {
	private String nome;
	private String partido;
	private int intencoesVotos;

	// Construtor com inicialização completa
	public Candidato(String nome, String partido, int intencoesVotos) {
		this.nome = nome;
		this.partido = partido;
		this.intencoesVotos = intencoesVotos;
	}

	// Getters e setters (métodos de acesso)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getIntencoesVotos() {
		return intencoesVotos;
	}

	public void setIntencoesVotos(int intencoesVotos) {
		this.intencoesVotos = intencoesVotos;
	}

	// toString
	@Override
	public String toString() {
		return String.format("Candidato{nome='%s', partido='%s', votos=%d}", nome, partido, intencoesVotos);
	}
}
