package model;

import java.util.List;

public class Carrello {
	public List<Piatto> piattiSelezionati;

	

	public Carrello(List<Piatto> piattiSelezionati) {
		this.piattiSelezionati = piattiSelezionati;
	}
	
	public List<Piatto> getLista() {
		return piattiSelezionati;
	}
	
	public void elaboraPrezzo() {
		
	}
	
	public void getPiattoSelezionato() {
		
	}
}
