package controller;


import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;

import classidb.Accountutenti;
import model.Connessione;

public class StudenteDocente extends Utente{
	public String nome;	
	public String cognome;
	public int matricola;
	public String email;
	public FasciaIsee fascia;
	public String passwordU;
	public float contoVirtuale;
	
	public StudenteDocente(String nome, String cognome, int matricola, String email, FasciaIsee fascia,
			String passwordU, float contoVirtuale) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.email = email;
		this.fascia = fascia;
		this.passwordU = passwordU;
		this.contoVirtuale = contoVirtuale;
	}
	
	public StudenteDocente() {
		
	}
	
	public float getContoVirtuale() {
		return contoVirtuale;
	}

	public void setContoVirtuale(float contoVirtuale) {
		this.contoVirtuale = contoVirtuale;
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
	
	public boolean login(int matricola, String pwd) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		boolean exists = dslContext.fetchExists(
			        dslContext.selectFrom(Accountutenti.ACCOUNTUTENTI).where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(matricola)
			        		.and(Accountutenti.ACCOUNTUTENTI.PASSWORD.eq(pwd))));
		if(exists) {
			return true;
		}
		return false;	
	 }
    
	public void registrazione(int matricola, String pwd, String nome, String cognome, String email, int fasciaIsee) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		dslContext.insertInto(Accountutenti.ACCOUNTUTENTI)
        .columns(Accountutenti.ACCOUNTUTENTI.MATRICOLA, Accountutenti.ACCOUNTUTENTI.PASSWORD, Accountutenti.ACCOUNTUTENTI.NOME,
        		Accountutenti.ACCOUNTUTENTI.COGNOME, Accountutenti.ACCOUNTUTENTI.EMAIL, Accountutenti.ACCOUNTUTENTI.FASCIAISEE)
        .values(matricola, pwd, nome, cognome, email, fasciaIsee)
        .execute();
	}
    	
	
}
