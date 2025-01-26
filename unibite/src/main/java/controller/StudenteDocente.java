package controller;

//Import
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record1;

import generated.tables.*;
import model.Connessione;

public class StudenteDocente extends Utente {
	public String nome;
	public String cognome;
	public int matricola;
	public String email;
	public FasciaIsee fascia;
	public String passwordU;
	public float contoVirtuale;

	//Costruttore
	public StudenteDocente(int matricola, String password, String nome, String cognome, String email, FasciaIsee fascia, float contoVirtuale) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.email = email;
		this.fascia = fascia;
		this.passwordU = passwordU;
		this.contoVirtuale = contoVirtuale;
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Inserimento del nuovo utente  di tipo StudenteDocente nella tabella degli account utenti nel db
		dslContext.insertInto(Accountutenti.ACCOUNTUTENTI)
				.columns(Accountutenti.ACCOUNTUTENTI.MATRICOLA, Accountutenti.ACCOUNTUTENTI.PASSWORD,
						Accountutenti.ACCOUNTUTENTI.NOME, Accountutenti.ACCOUNTUTENTI.COGNOME,
						Accountutenti.ACCOUNTUTENTI.EMAIL, Accountutenti.ACCOUNTUTENTI.FASCIAISEE)
				.values(matricola, password, nome, cognome, email, fascia.getValue()).execute();
	}

	public StudenteDocente() {

	}
	
	public StudenteDocente(int matricola) {
		this.matricola=matricola;
	}

	//Funzioni getter
	public float getContoVirtuale(int matricola) {
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Cerca l'ammontare del conto dell'utente nel b
		List<Record1<BigDecimal>> result = dslContext.select(Accountutenti.ACCOUNTUTENTI.CONTO)
				.from(Accountutenti.ACCOUNTUTENTI).where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(matricola)).fetch();
		//Ritorna l'ammontare del conto virtuale come un valore float arrotondato per eccesso alla seconda cifra decimale
		return result.get(0).value1().setScale(2, RoundingMode.HALF_UP).floatValue();
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getMatricola() {
		return matricola;
	}

	public String getEmail() {
		return email;
	}

	public FasciaIsee getFascia() {
		return fascia;
	}

	public String getPasswordU() {
		return passwordU;
	}

	//Metodo che permette ad un utente di tipo StudenteDocente di effettuare il login nel suo account
	public boolean login(int matricola, String pwd) {
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Controlla che l'username e la password inseriti siano presenti nel db e che queste siano corrette
		//Restituisce true o false
		return dslContext.fetchExists(dslContext.selectFrom(Accountutenti.ACCOUNTUTENTI).where(
				Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(matricola).and(Accountutenti.ACCOUNTUTENTI.PASSWORD.eq(pwd))));
	}

}
