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
	//inizializzazione logger;	
	private static final Logger LOGGER = LogManager.getLogger(Carrello.class);
	/*creazione lista dei piatti nel carrello
	 * nel primo string è inserito il nome del piatto
	 * nel secondo string è inserito, se richiesto, "Aggiungi Formaggio"
	*/
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
	
	//metodo per elaborare il prezzo totale, usato per gli utenti esterni
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
	
	//metodo per elaborare il prezzo totale scontato, usato per gli StudentiDocenti
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
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.8))); //Fascia A
		}else if(fascia.get(0).value1() == 2) {
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.6))); //Fascia B
		}else if(fascia.get(0).value1() == 3) {
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.3))); //Fascia C
		}else {
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.05)));} //Resto delle fasce
		return prezzoTot;
	}
	
	//metodo richiamato nel portale ordinazione, per aggiungere piatti al carrello
	public  void aggiungiPiatto(String nome) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		String piatto = result.get(0).value1();
		String valore = " ";
		piattiSelezionati.add(new AbstractMap.SimpleEntry<>(piatto, valore));
		
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, Piatti.PIATTI.NUMEROPORZIONI.minus(1))
		.where(Piatti.PIATTI.NOME.eq(nome)).execute();
		LOGGER.info(piattiSelezionati);
		if(observers.size()>=1) {
			notifyObservers(nome);
		}
	}
	
	//metodo richiamato nel portale ordinazione, per aggiungere i piatti al carrello con il formaggio
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
		
		if(observers.size()>=1) {
			notifyObservers(nome);
		}
	}
	
	//metodo per eliminare un piatto dal carrello
	public  void eliminaPiatto(Set<Map.Entry<String, String>> selezione) {
		int conta=0;
		LOGGER.info(selezione);
		Entry<String, String> primoRecord = selezione.iterator().next();
		String nomePiatto = primoRecord.getKey();
		LOGGER.info(nomePiatto);
		conta=piattiSelezionati.size();
		piattiSelezionati.removeIf(entry -> entry.getKey().equals(nomePiatto));	
		conta = conta - piattiSelezionati.size();
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, Piatti.PIATTI.NUMEROPORZIONI.add(conta))
		.where(Piatti.PIATTI.NOME.eq(nomePiatto)).execute();
	}
	
	//lista di observer che saranno notificati
	private final List<CarrelloObserver> observers = new ArrayList<>();

	/* metodo per aggiungere un nuovo observer alla lista
	 * questo permette a un oggetto che implementa l'interfaccia CarrelloObserver 
	 * di essere notificato
	*/
	public void addObserver(CarrelloObserver observer) {
	    observers.add(observer);
	    LOGGER.info(observers);
	}

	//metodo per rimuovere un osservatore dalla lista.
	public void removeObserver(CarrelloObserver observer) {
	    observers.remove(observer);
	}

	/*metodo per notificare gli osservatori quando avviene un'azione 
	 * ovvero l'aggiunta di un piatto al carrello)
	 */
	public void notifyObservers(String nomePiatto) {
	    //recupera l'ultimo osservatore aggiunto nella lista
	    CarrelloObserver observer = observers.get(observers.size() - 1);
	    //notifica l'osservatore chiamando il metodo definito nella sua interfaccia, passando il nome del piatto
	    observer.onPiattoAggiunto(nomePiatto);
	}


}
