package controller;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jooq.DSLContext;
import org.jooq.Record1;

import generated.tables.*;
import model.Connessione;

public class Carrello {
	private static final Logger logger = LogManager.getLogger(Carrello.class);
	public static List<Map.Entry<String, String>> piattiSelezionati = new ArrayList<>();
	private int matricola;
	
	public Carrello(int matricola) {
		this.matricola=matricola;
		piattiSelezionati = new ArrayList<>();
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public List<Map.Entry<String, String>> getLista() {	
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
	
	public BigDecimal elaboraPrezzoScontato(int mat) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		BigDecimal prezzoTot = BigDecimal.ZERO;
		for (Map.Entry<String, String> entry : piattiSelezionati) {
		    String nome = entry.getKey();
		    List<Record1<BigDecimal>> result = dslContext.select(Piatti.PIATTI.PREZZOUNITARIO)
			.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		prezzoTot = prezzoTot.add(result.get(0).value1());   
		}
		List<Record1<Integer>> fascia = dslContext.select(Accountutenti.ACCOUNTUTENTI.FASCIAISEE)
				.from(Accountutenti.ACCOUNTUTENTI).where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(mat)).fetch();
		if(fascia.get(0).value1() == 1) {
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply((BigDecimal.valueOf(0.8))));
		}else if(fascia.get(0).value1() == 2) {
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply((BigDecimal.valueOf(0.6))));
		}else if(fascia.get(0).value1() == 3) {
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply((BigDecimal.valueOf(0.3))));
		}else {
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply((BigDecimal.valueOf(0.05))));
		}	
		return prezzoTot;
	}
	
	
	public  void aggiungiPiatto(String nome) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		String piatto = result.get(0).value1();
		logger.info(piatto);
		String valore = " ";
		piattiSelezionati.add(new AbstractMap.SimpleEntry<>(piatto, valore));
		
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, Piatti.PIATTI.NUMEROPORZIONI.minus(1))
		.where(Piatti.PIATTI.NOME.eq(nome)).execute();
		
		notifyObservers(nome);
	}
	
	public  void aggiungiPiattoConFormaggio(String nome) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		String piatto = result.get(0).value1();
		String valore = "Aggiungi Formaggio";
		piattiSelezionati.add(new AbstractMap.SimpleEntry<>(piatto, valore));
		
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, Piatti.PIATTI.NUMEROPORZIONI.minus(1))
		.where(Piatti.PIATTI.NOME.eq(nome)).execute();
		
		notifyObservers(nome);
	}
	
	public  void eliminaPiatto(Set<Map.Entry<String, String>> selezione) {
		int conta=0;
		Entry<String, String> primoRecord = selezione.iterator().next();
		String nomePiatto = primoRecord.getKey();
		logger.info(nomePiatto);
		conta=piattiSelezionati.size();
		piattiSelezionati.removeIf(entry -> entry.getKey().equals(nomePiatto));	
		conta = conta - piattiSelezionati.size();
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, Piatti.PIATTI.NUMEROPORZIONI.add(conta))
		.where(Piatti.PIATTI.NOME.eq(nomePiatto)).execute();
	}
	
	
	private final List<CarrelloObserver> observers = new ArrayList<>();
		public void addObserver(CarrelloObserver observer) {
	        observers.add(observer);
	        logger.info(observers);
	    }

	    public void removeObserver(CarrelloObserver observer) {
	        observers.remove(observer);
	    }

	    public void notifyObservers(String nomePiatto) {
	        CarrelloObserver observer = observers.get(observers.size()-1);
	            observer.onPiattoAggiunto(nomePiatto);
	
	    }

}
