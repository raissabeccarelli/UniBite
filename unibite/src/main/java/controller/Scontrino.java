package controller;

//Classe per la creazione di uno scontrino con numero seriale
public class Scontrino {
	//Contatore inizializzato a 0
	private static int contatore = 0; 
    private int numeroSeriale; 

    //Costruttore
	public Scontrino() {
		//Impostazione del numero seriale dello scontrino 
		//al valore del contatore incrementato di 1
		this.numeroSeriale = ++contatore;
	}

	//Funzione getter
	public int getNumeroSeriale() {
		return numeroSeriale;
	}

}
