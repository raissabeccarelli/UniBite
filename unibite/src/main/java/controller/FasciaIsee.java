package controller;

public enum FasciaIsee {
	A(1), B(2), C(3), D(4), E(5), F(6), G(7);
	
	private final int i;

	FasciaIsee(int i) {
		this.i = i;
	}

	public int getValue() {
		return i;
	}

}
