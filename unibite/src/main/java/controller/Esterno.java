package controller;

public class Esterno extends Utente {
	//assegnazione codice univoco agli utenti esterni
	public int codice=0000;
	public Esterno(int codice) {
		this.codice=codice;
	}
	public int getCodice() {
		return codice;
	}
}
