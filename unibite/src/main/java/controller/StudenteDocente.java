package controller;

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
	
	public void login() {
		
	}
}
