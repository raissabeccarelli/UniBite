package controller;

import java.util.List;


import org.jooq.DSLContext;
import org.jooq.Record2;

import com.vaadin.flow.data.binder.Result;

import classidb.Piatti;
import model.Connessione;

public class Piatto {
	public String nome;	
	public String descrizione;
	public String ingredienti;
	public TipoPortata tipo;
	public float prezzoUnitario;
	public int numeroPorzioni;
	
	public Piatto(String nome, String descrizione, String ingredienti, TipoPortata tipo, float prezzoUnitario,
			int numeroPorzioni) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		this.tipo = tipo;
		this.prezzoUnitario = prezzoUnitario;
		this.numeroPorzioni = numeroPorzioni;
	}
	public Piatto() {
		
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public TipoPortata getTipo() {
		return tipo;
	}

	public void setTipo(TipoPortata tipo) {
		this.tipo = tipo;
	}

	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(float prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public int getNumeroPorzioni() {
		return numeroPorzioni;
	}

	public void setNumeroPorzioni(int numeroPorzioni) {
		this.numeroPorzioni = numeroPorzioni;
	}
	
	public static List<Record2<String,Integer>> cercaPiatti() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record2<String,Integer>> result = dslContext
		        .select(Piatti.PIATTI.NOME, Piatti.PIATTI.NUMEROPORZIONI)
		        .from(Piatti.PIATTI)
		        .fetch();

		   
		    return result;
	}

	

}
