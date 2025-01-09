package controller;

import org.jooq.DSLContext;


import classidb.*;
import model.Connessione;

public class StudenteDocente extends Utente {
	public String nome;
	public String cognome;
	public int matricola;
	public String email;
	public int fascia;
	public String passwordU;
	public float contoVirtuale;

	public StudenteDocente(int matricola, String password, String nome, String cognome, String email, int fascia,
			float contoVirtuale) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.email = email;
		this.fascia = fascia;
		this.passwordU = passwordU;
		this.contoVirtuale = contoVirtuale;
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		dslContext.insertInto(Accountutenti.ACCOUNTUTENTI)
				.columns(Accountutenti.ACCOUNTUTENTI.MATRICOLA, Accountutenti.ACCOUNTUTENTI.PASSWORD,
						Accountutenti.ACCOUNTUTENTI.NOME, Accountutenti.ACCOUNTUTENTI.COGNOME,
						Accountutenti.ACCOUNTUTENTI.EMAIL, Accountutenti.ACCOUNTUTENTI.FASCIAISEE)
				.values(matricola, password, nome, cognome, email, fascia).execute();
	}

	public StudenteDocente() {

	}
	
	public StudenteDocente(int matricola) {
		this.matricola=matricola;
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

	public int getFascia() {
		return fascia;
	}

	public String getPasswordU() {
		return passwordU;
	}

	public boolean login(int matricola, String pwd) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		boolean exists = dslContext.fetchExists(dslContext.selectFrom(Accountutenti.ACCOUNTUTENTI).where(
				Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(matricola).and(Accountutenti.ACCOUNTUTENTI.PASSWORD.eq(pwd))));
		if (exists) {
			return true;
		}
		return false;
	}

}
