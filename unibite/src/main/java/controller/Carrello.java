package controller;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.jooq.DSLContext;
import org.jooq.Record1;

import classidb.Piatti;
import model.Connessione;

public class Carrello {
	//public static List<Record2<String, String>> piattiSelezionati;
	
	public static List<Map.Entry<String, String>> piattiSelezionati = new ArrayList<>();
	private int matricola;
	
	public Carrello(int matricola) {
		this.matricola=matricola;
		this.piattiSelezionati = new ArrayList<Map.Entry<String, String>>();
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public static List<Map.Entry<String, String>> getLista() {	
		return piattiSelezionati;
	}

	public BigDecimal elaboraPrezzo() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		BigDecimal prezzoTot = BigDecimal.ZERO;
		for (Map.Entry<String, String> entry : piattiSelezionati) {
		    String nome = entry.getKey();
		    List<Record1<BigDecimal>> result = dslContext.select(Piatti.PIATTI.PREZZOUNITARIO)
			.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		prezzoTot = prezzoTot.add(result.get(0).value1());   
		}
		return prezzoTot;
	}
	
	
	public static void aggiungiPiatto(String nome) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		String piatto = result.get(0).value1();
		System.out.println(piatto);
		String valore = " ";
		piattiSelezionati.add(new AbstractMap.SimpleEntry<>(piatto, valore));
		
	}
	
	public static void aggiungiPiattoConFormaggio(String nome) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		String piatto = result.get(0).value1();
		String valore = "Aggiungi Formaggio";
		piattiSelezionati.add(new AbstractMap.SimpleEntry<>(piatto, valore));
	}
	


}
