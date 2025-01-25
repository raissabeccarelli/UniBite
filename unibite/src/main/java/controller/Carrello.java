package controller;

//Import
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
	
	//Costruttore
	public Carrello(int matricola) {
		this.matricola=matricola;
		piattiSelezionati = new ArrayList<>();
	}
	
	//Funzioni getter
	public int getMatricola() {
		return matricola;
	}
	
	public List<Map.Entry<String, String>> getLista() {	
		//Ritorna la lista dei piatti nel carrello
		return piattiSelezionati;
	}
	
	//Metodo per elaborare il prezzo totale
	//usato per gli utenti esterni (non hanno sconti)
	public BigDecimal elaboraPrezzo() {
		//accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Inizializzazione del prezzo totale a 0
		BigDecimal prezzoTot = BigDecimal.ZERO;
		//Scorrimento el carrello ed aggiunta del costo di ogni piatto al prezzo totale
		for (Map.Entry<String, String> entry : piattiSelezionati) {
		    String nome = entry.getKey();
		    List<Record1<BigDecimal>> result = dslContext.select(Piatti.PIATTI.PREZZOUNITARIO)
			.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		prezzoTot = prezzoTot.add(result.get(0).value1());   
		}
		//Ritorna il prezzo totale del carrello
		return prezzoTot;
	}
	
	//metodo per elaborare il prezzo totale scontato, usato per gli StudentiDocenti
	public BigDecimal elaboraPrezzoScontato(int mat) {
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Inizializzazione del prezzo totale a 0
		BigDecimal prezzoTot = BigDecimal.ZERO;
		//Scorrimento el carrello ed aggiunta del costo di ogni piatto al prezzo totale
		for (Map.Entry<String, String> entry : piattiSelezionati) {
		    String nome = entry.getKey();
		    List<Record1<BigDecimal>> result = dslContext.select(Piatti.PIATTI.PREZZOUNITARIO)
			.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		prezzoTot = prezzoTot.add(result.get(0).value1());   
		}
		
		//Cerca nel db di quale fascia ISEE fa parte l'utente
		List<Record1<Integer>> fascia = dslContext.select(Accountutenti.ACCOUNTUTENTI.FASCIAISEE)
				.from(Accountutenti.ACCOUNTUTENTI).where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(mat)).fetch();
		//A seconda della fascia ISEE di appartenenza, l'utente di tipo StudenteDocente 
		//ha diritto ha uno sconto in percentuale prefissato
		//Calcolo del prezzo scontato
		if(fascia.get(0).value1() == 1) {//Fascia A
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.8))); 
		}else if(fascia.get(0).value1() == 2) {//Fascia B
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.6))); 
		}else if(fascia.get(0).value1() == 3) {//Fascia C
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.3))); 
		}else {//Resto delle fasce
			prezzoTot = prezzoTot.subtract(prezzoTot.multiply(BigDecimal.valueOf(0.05)));} 
		//Ritorna il prezzo scontato del carrello
		return prezzoTot;
	}
	
	//Metodo richiamato nel portale ordinazione, per aggiungere piatti al carrello
	public  void aggiungiPiatto(String nome) {
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Aggiunta al carrello del piatto desiderato
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		String piatto = result.get(0).value1();
		//Il secondo campo è utilizzato per la specifica dell'aggiunta di formaggio per i primi piatti
		//Vedi il etodo successivo
		String valore = " ";
		piattiSelezionati.add(new AbstractMap.SimpleEntry<>(piatto, valore));
		
		//Aggiornamento del db, riduzione di un'unità del numero di porzioni disponibili del piatto selezionato
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, Piatti.PIATTI.NUMEROPORZIONI.minus(1))
		.where(Piatti.PIATTI.NOME.eq(nome)).execute();
		LOGGER.info(piattiSelezionati);
		if(observers.size()>=1) {
			notifyObservers(nome);
		}
	}
	
	//Metodo richiamato nel portale ordinazione, per aggiungere i primi piatti con il formaggio al carrello 
	public  void aggiungiPiattoConFormaggio(String nome) {
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Aggiunta al carrello del piatto desiderato
		List<Record1<String>> result = dslContext.select(Piatti.PIATTI.NOME)
		.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(nome)).fetch();
		String piatto = result.get(0).value1();
		//Specifica dell'aggiunta di formaggio al piatto
		String valore = "Aggiungi Formaggio";
		piattiSelezionati.add(new AbstractMap.SimpleEntry<>(piatto, valore));
		
		//Aggiornamento del db, riduzione di un'unità del numero di porzioni disponibili del piatto selezionato
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
	
	//Lista di observer che saranno notificati
	private final List<CarrelloObserver> observers = new ArrayList<>();

	/* Metodo per aggiungere un nuovo observer alla lista
	 * questo permette a un oggetto che implementa l'interfaccia CarrelloObserver 
	 * di essere notificato
	*/
	public void addObserver(CarrelloObserver observer) {
	    observers.add(observer);
	    LOGGER.info(observers);
	}

	//Metodo per rimuovere un observer dalla lista.
	public void removeObserver(CarrelloObserver observer) {
	    observers.remove(observer);
	}

	/*Metodo per notificare gli osservatori quando avviene un'azione 
	 *(ovvero l'aggiunta di un piatto al carrello)
	 */
	public void notifyObservers(String nomePiatto) {
	    //Recupera l'ultimo osservatore aggiunto nella lista
	    CarrelloObserver observer = observers.get(observers.size() - 1);
	    //Notifica l'osservatore chiamando il metodo definito nella sua interfaccia, passando il nome del piatto
	    observer.onPiattoAggiunto(nomePiatto);
	}


}
