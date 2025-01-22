package unibite;

import static org.junit.jupiter.api.Assertions.*;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;

import controller.Personale;
import controller.TipoPortata;
import generated.tables.Accountutenti;
import generated.tables.Piatti;
import model.Connessione;

class PersonaleTest {
	Personale p;
	
	public PersonaleTest(){
		p = new Personale();
	}
	@Test public void loginTest() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//verifico se trova la matricola
		boolean result = dslContext.fetchExists(dslContext.selectFrom(Accountutenti.ACCOUNTUTENTI).where(
				Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(1086785)));
		assertTrue(result);
		//verifico se a quella matricola è associata la password corretta
		assertTrue(p.login("personale1", "mensa77"));
	}
	
	@Test public void creaPiattoTest() {
		p.creaNuovoPiatto("Spezzatino di maiale", "Lo spezzatino di maiale è un "
				+ "piatto rustico fatto con cubetti di carne di maiale cotti "
				+ "lentamente in un soffritto di cipolla, carota e sedano, "
				+ "arricchiti con brodo, vino o salsa di pomodoro.", 
				"carne di maiale, salsa di pomodoro, patate, carote", "sedano, solfiti", 
				TipoPortata.SECONDO, "carne");
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		boolean result = dslContext.fetchExists(dslContext.selectFrom(Piatti.PIATTI).where(
				Piatti.PIATTI.NOME.eq("Spezzatino di maiale")));
		assertTrue(result);
	}
	
}
