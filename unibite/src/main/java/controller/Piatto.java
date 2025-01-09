package controller;

import java.math.BigDecimal;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record2;
import classidb.*;
import model.Connessione;

public class Piatto {
	public String nome;
	public String descrizione;
	public String ingredienti;
	public String allergeni;
	public TipoPortata tipo;
	public float prezzoUnitario;
	public int numeroPorzioni;
	public String immagine;

	public Piatto(String nome, String descrizione, String ingredienti, String allergeni, TipoPortata tipo,
			float prezzoUnitario, String immagine, int numeroPorzioni) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		this.allergeni = allergeni;
		this.tipo = tipo;
		this.prezzoUnitario = prezzoUnitario;
		this.numeroPorzioni = numeroPorzioni;
		this.immagine = immagine;
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		dslContext.insertInto(Piatti.PIATTI)
				.columns(Piatti.PIATTI.NOME, Piatti.PIATTI.DESCRIZIONE, Piatti.PIATTI.INGREDIENTI,
						Piatti.PIATTI.ALLERGENI, Piatti.PIATTI.TIPOPORTATA, Piatti.PIATTI.PREZZOUNITARIO,
						Piatti.PIATTI.IMMAGINE)
				.values(nome, descrizione, ingredienti, allergeni, tipo.getValue(),
						BigDecimal.valueOf(setPrezzoUnitario(tipo)), immagine)
				.execute();
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

	public float setPrezzoUnitario(TipoPortata t) {

		if (t.getValue() == 1) {
			this.prezzoUnitario = (float) 01.99;
		} else if (t.getValue() == 2) {
			this.prezzoUnitario = (float) 02.69;
		} else if (t.getValue() == 3) {
			this.prezzoUnitario = (float) 00.69;
		} else if (t.getValue() == 4) {
			this.prezzoUnitario = (float) 00.99;
		} else {
			this.prezzoUnitario = (float) 00.0;
		}
		return this.prezzoUnitario;
	}

	public int getNumeroPorzioni() {
		return numeroPorzioni;
	}

	public void setNumeroPorzioni(String nome, int numeroPorzioni) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, numeroPorzioni)
				.where(Piatti.PIATTI.NOME.eq(nome)).execute();

	}

	public static List<Record2<String, Integer>> cercaPiatti() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record2<String, Integer>> result = dslContext.select(Piatti.PIATTI.NOME, Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).fetch();

		return result;
	}

}
