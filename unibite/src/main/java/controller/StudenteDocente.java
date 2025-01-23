package controller;

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

	public StudenteDocente(int matricola, String password, String nome, String cognome, String email, FasciaIsee fascia, float contoVirtuale) {
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
				.values(matricola, password, nome, cognome, email, fascia.getValue()).execute();
	}

	public StudenteDocente() {

	}
	
	public StudenteDocente(int matricola) {
		this.matricola=matricola;
	}

	public float getContoVirtuale(int matricola) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record1<BigDecimal>> result = dslContext.select(Accountutenti.ACCOUNTUTENTI.CONTO)
				.from(Accountutenti.ACCOUNTUTENTI).where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(matricola)).fetch();
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

	public boolean login(int matricola, String pwd) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		return dslContext.fetchExists(dslContext.selectFrom(Accountutenti.ACCOUNTUTENTI).where(
				Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(matricola).and(Accountutenti.ACCOUNTUTENTI.PASSWORD.eq(pwd))));
	}

}
