package unibite;

import static org.junit.jupiter.api.Assertions.*;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.junit.jupiter.api.Test;

import controller.Carrello;
import controller.Piatto;
import generated.tables.Piatti;
import model.Connessione;

class CarrelloTest {
	Carrello c;
	
	public CarrelloTest() {
		c=new Carrello(1);
	}

	//Test che controlla che la matricoa associata al carrello sia corretta
	@Test public void testgetMatricola() {
		assertEquals(1, c.getMatricola());
	}
	
	//Test che verifica che la creazione del carrello crei una lista vuota
	@Test public void testgetLista() {
		assertNull(c.getLista());
		assertEquals(0, c.elaboraPrezzo());
	}
	
	//Test che verifica che si possa aggiungere un piatto correttamente al carrello
	@Test public void testAggiiungiPiatto() {
		Piatto p=new Piatto("Piatto1", null, null, null, null, 0, null, 0);
		c.aggiungiPiatto(p.getNome());
		assertEquals("Piatto1", c.getLista().getFirst().getKey());
	}
	
	//Test che verifica che si possa aggiungere un primo piatto con formaggio correttamente al carrello
		@Test public void testAggiiungiPiattoFormaggio() {
			Piatto p=new Piatto("Piatto1", null, null, null, null, 0, null, 0);
			c.aggiungiPiattoConFormaggio(p.getNome());
			assertEquals("Piatto1", c.getLista().getFirst().getKey());
			assertEquals("Aggiungi Formaggio", c.getLista().getFirst().getValue());  //?
		}
		
	//Test che verifica che la cncellazione di un elemento dal carrello lo rimuova effettivamente dal carrello
	@Test public void testeliminaPiatto() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
        c.aggiungiPiatto("Braciola di maiale");
		assertNotNull(c.getLista());
		@NotNull Result<Record1<Integer>> nIniz = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Braciola di maiale")).fetch();
		//elimina piatto appena inserito dal carrello
		//conta nuovo num elementi in db
		//verifica che è aumentatoo di 1
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
