package controller;

public class Scontrino {
	private static int contatore = 0; 
    private int numeroSeriale; 

	public Scontrino() {
		this.numeroSeriale = ++contatore;
	}

	public int getNumeroSeriale() {
		return numeroSeriale;
	}

}
