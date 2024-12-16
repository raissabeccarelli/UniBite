package controller;

public enum TipoPortata {
	PRIMO(1), SECONDO(2), CONTORNO(3), DOLCEFRUTTA(4);

	private final int i;

	TipoPortata(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

}
