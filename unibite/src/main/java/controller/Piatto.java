package controller;

public class Piatto {
	public String nome;	
	public String descrizione;
	public String ingredienti;
	public TipoPortata tipo;
	public float prezzoUnitario;
	public int numeroPorzioni;
	
	public Piatto(String nome, String descrizione, String ingredienti, TipoPortata tipo, float prezzoUnitario,
			int numeroPorzioni) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		this.tipo = tipo;
		this.prezzoUnitario = prezzoUnitario;
		this.numeroPorzioni = numeroPorzioni;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public TipoPortata getTipo() {
		return tipo;
	}

	public void setTipo(TipoPortata tipo) {
		this.tipo = tipo;
	}

	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(float prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public int getNumeroPorzioni() {
		return numeroPorzioni;
	}

	public void setNumeroPorzioni(int numeroPorzioni) {
		this.numeroPorzioni = numeroPorzioni;
	}

	

}
