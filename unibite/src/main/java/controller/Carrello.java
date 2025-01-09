package controller;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;

import classidb.Piatti;
import model.Connessione;

public class Carrello {
	public static List<Record1<String>> piattiSelezionati;
	private int matricola;
	
	public Carrello(int matricola) {
		this.matricola=matricola;
		this.piattiSelezionati = new ArrayList<Record1<String>>();
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public static List<Record1<String>> getLista() {	
		return piattiSelezionati;
	}

	public void elaboraPrezzo() {

	}
	
	
	public static void aggiungiPiatto(String nome) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		Record1<String> piatto = result.get(0);
		piattiSelezionati.add(piatto);
	}

}
