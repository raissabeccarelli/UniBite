package controller;

//Import
import java.math.BigDecimal;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record2;
import generated.tables.*;
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

	//Costruttore
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
		//Accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Inserimento del piatto creato nella tabella dei piatti del db
		dslContext.insertInto(Piatti.PIATTI)
				.columns(Piatti.PIATTI.NOME, Piatti.PIATTI.DESCRIZIONE, Piatti.PIATTI.INGREDIENTI,
						Piatti.PIATTI.ALLERGENI, Piatti.PIATTI.TIPOPORTATA, Piatti.PIATTI.PREZZOUNITARIO, Piatti.PIATTI.IMMAGINE, Piatti.PIATTI.NUMEROPORZIONI)
				.values(nome, descrizione, ingredienti, allergeni, tipo.getValue(),	BigDecimal.valueOf(setPrezzoUnitario(tipo)), immagine, numeroPorzioni)
				.execute();
	}

	public Piatto() {

	}

	//Funzioni getter e setter
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

	//Imposta per ogni piatto un prezzo prefissato a seconda del tipo di portata
	public float setPrezzoUnitario(TipoPortata t) {

		if (t.getValue() == 1) {
			this.prezzoUnitario = (float) 1.99;
		} else if (t.getValue() == 2) {
			this.prezzoUnitario = (float) 2.69;
		} else if (t.getValue() == 3) {
			this.prezzoUnitario = (float) 0.69;
		} else if (t.getValue() == 4) {
			this.prezzoUnitario = (float) 0.99;
		} else {
			this.prezzoUnitario = (float) 0.0;
		}
		return this.prezzoUnitario;
	}

	public int getNumeroPorzioni() {
		return numeroPorzioni;
	}

	public void setNumeroPorzioni(String nome, int numeroPorzioni) {
		//accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Imposta il numero di porzioni del piatto desiderato al numero indicato
		dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, numeroPorzioni)
				.where(Piatti.PIATTI.NOME.eq(nome)).execute();

	}

	//Metodo che permette di estrarre tutti i piatti
	public static List<Record2<String, Integer>> cercaPiatti() {
		//accesso al db
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//Ritorna una lista di piatti recante il nome del piatto ed il corrispondente numero di porzioni
		return  dslContext.select(Piatti.PIATTI.NOME, Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).fetch();
	}

}
