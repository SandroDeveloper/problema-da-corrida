
public class Corredor {

	private String nome;
	private char sexo;
	private float tempoDeProva;
	
	public Corredor() {}
	
	public Corredor(String nome, char sexo, float tempoDeProva) {
		this.nome = nome;
		this.sexo = sexo;
		this.tempoDeProva = tempoDeProva;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	
	public float getTempoDeProva() {
		return this.tempoDeProva;
	}

	@Override
	public String toString() {
		return "Corredor Vencedor [nome=" + nome + ", sexo=" + sexo + "]";
	}
	
	
}
