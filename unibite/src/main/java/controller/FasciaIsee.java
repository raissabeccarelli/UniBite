package controller;

//Classe enumerativa
public enum FasciaIsee {
	//Assegnazione di un valore intero alle fasce ISEE
	A(1), B(2), C(3), D(4), E(5), F(6), G(7);
	
	private final int i;

	//Costruttore
	FasciaIsee(int i) {
		this.i = i;
	}

	//Metodo getter
	public int getValue() {
		return i;
	}

}
