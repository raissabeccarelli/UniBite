package controller;

public class Esterno extends Utente {
	public static int codice=0000;
	public Esterno(int codice) {
		this.codice=codice;
	}
	public int getCodice() {
		return codice;
	}
}
