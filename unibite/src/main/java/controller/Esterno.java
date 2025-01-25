package controller;

public class Esterno extends Utente {
	//Assegnazione codice univoco agli utenti esterni in sostituzione della matricola
	public int codice=0000;
	//Costruttore
	public Esterno(int codice) {
		this.codice=codice;
	}
	
	//Matodo getter
	public int getCodice() {
		return codice;
	}
}
