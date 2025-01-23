package unibite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;
import org.junit.jupiter.api.Test;

import controller.Personale;
import controller.TipoPortata;
import generated.tables.Accountpersonale;
import generated.tables.Accountutenti;
import generated.tables.Piatti;
import model.Connessione;

class PersonaleTest {
	Personale p;
	
	public PersonaleTest(){
		p = new Personale();
	}
	
	//Test che verifica che il personale possa effettuare il login in modo corretto
	@Test void loginTest() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//verifico se trova la matricola
		boolean result = dslContext.fetchExists(dslContext.selectFrom(Accountpersonale.ACCOUNTPERSONALE).where(
				Accountpersonale.ACCOUNTPERSONALE.USERNAME.eq("personale1")));
		assertTrue(result);
		//verifico se a quella matricola è associata la password corretta
		assertTrue(p.login("personale1", "mensa77"));
		assertFalse(p.login("personale1", "1234"));
	}
	
	//Tst che verifica che il personale possa creare un nuovo piatto da aggiunngere  al menù
	@Test void creaPiattoTest() {
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
		
		
		//eliminazione del piatto creato dal database
		dslContext.deleteFrom(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Spezzatino di maiale")).execute();
	}
	
	/*@Test void testAggiungiPorzioni() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		
		Result<Record1<Integer>> nIniz = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Pasta al ragù")).fetch();
		int inizio=nIniz.getFirst().value1();
		
		Set<Record2<String, Integer>> piatto =  new Record2<String, Integer> ("Pasta al ragù", inizio);
		Set<Record2<String, Integer>> selezione = new HashSet<>();
		selezione.add(piatto);
		p.aggiungiPorzioni(selezione, inizio+40); 
		
		Result<Record1<Integer>> nFin = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Pasta al ragù")).fetch();
		int fine=nFin.getFirst().value1();
		
		assertEquals(40, fine-inizio);
		p.aggiungiPorzioni(selezione, inizio);
	}*/
}
