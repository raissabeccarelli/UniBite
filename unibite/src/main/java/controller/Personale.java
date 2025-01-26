package controller;

//Import
import java.util.Set;

import org.jooq.DSLContext;
import org.jooq.Record2;

import generated.tables.*;
import model.Connessione;

public class Personale {
	public String username;
	public String passwordP;

	//Costruttore
	public Personale(String username, String passwordP) {
		this.username = username;
		this.passwordP = passwordP;
	}

	public Personale() {

	}

	//Funzioni getter
	public String getUsername() {
		return username;
	}

	public String getPasswordP() {
		return passwordP;
	}

	//Metodo che dati dei paramtri adeguati permette di creare un nuovo piatto
	public void creaNuovoPiatto(String n, String d, String in, String all, TipoPortata t, String c) {
		//Prezzo inizializzato a 0
		float pr = 0;
		//Numero di porzioni inizializzate a 0
		int po = 0;
		Piatto p = new Piatto(n, d, in, all, t, pr, c, po);
	}

	//Metodo che, selezionando un piatto esistente, permette di impostre il numero di porzioni ad un numero desiderato
	public void aggiungiPorzioni(Set<Record2<String, Integer>> dato, int quantita) {
		//Selezione del piatto di interesse
		Record2<String, Integer> primoRecord = dato.iterator().next();
		String nomePiatto = primoRecord.value1();
		Piatto piatto = new Piatto();
		//Impostazione del numero di porzioni (NON E'UNA SOMMA!)
		piatto.setNumeroPorzioni(nomePiatto, quantita);
	}

	//Metodo che, selezionando un piatto esistente, permette di eliminarlo (imposta il numero di porzioni a 0)
	public void eliminaPiatto(Set<Record2<String, Integer>> dato) {
		//Selezione del piatto di interesse
		Record2<String, Integer> primoRecord = dato.iterator().next();
		String nomePiatto = primoRecord.value1();
		Piatto piatto = new Piatto();
		//Eliminazione piatto (num. porzioni = 0)
		piatto.setNumeroPorzioni(nomePiatto, 0);
	}

	//Metodo che permette ai componenti del personale di fare il login ed accedere alle viste dedicate
	public boolean login(String username, String pwd) {
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Controllo della correttezza di username e password inseriti
		return dslContext.fetchExists(dslContext.selectFrom(Accountpersonale.ACCOUNTPERSONALE)
				.where(Accountpersonale.ACCOUNTPERSONALE.USERNAME.eq(username)
						.and(Accountpersonale.ACCOUNTPERSONALE.PASSWORDP.eq(pwd))));
	}
}
