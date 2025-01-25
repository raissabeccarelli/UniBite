package controller;

//Classe enumerativa
public enum TipoPortata {
	PRIMO(1), SECONDO(2), CONTORNO(3), DOLCEFRUTTA(4);

	private final int i;

    //Costruttore
	TipoPortata(int i) {
		this.i = i;
	}

    //Funzione getter
	public int getValue() {
		return i;
	}

}
