package unibite;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import controller.Carrello;
import controller.Piatto;
import controller.TipoPortata;
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
		assertTrue(c.getLista().isEmpty());
	}
	
	//verifica che il prezzo iniziale del carrello sia zero
	@Test public void testPrezzoIniziale() {
		assertEquals(BigDecimal.ZERO, c.elaboraPrezzo());
	}
	
	//Test che verifica che si possa aggiungere un piatto correttamente al carrello
	@Test public void testAggiungiPiatto() {
		//aggiunge piatto al carrello
		//assertTrue(c.getLista().isEmpty());
		c.aggiungiPiatto("Braciola di maiale");
		assertEquals("Braciola di maiale", c.getLista().get(0).getKey());
	}
	
	//Test che verifica che si possa aggiungere un primo piatto con formaggio correttamente al carrello
		@Test public void testAggiungiPiattoFormaggio() {
			c.aggiungiPiattoConFormaggio("Pasta al ragù");
			assertEquals("Pasta al ragù", c.getLista().getFirst().getKey());
			assertEquals("Aggiungi Formaggio", c.getLista().getFirst().getValue());
		}
		
	  
	//Test che verifica che l'aggiunta di un piatto al carrello diminuisca le porzioni nel database
	@Test public void testdiminuisciPiatto() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		Result<Record1<Integer>> nIniz = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Braciola di maiale")).fetch();
		int inizio=nIniz.getFirst().value1();
        c.aggiungiPiatto("Braciola di maiale");
		assertFalse(c.getLista().isEmpty());
		@NotNull Result<Record1<Integer>> nFin = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Braciola di maiale")).fetch();
		int fine=nFin.getFirst().value1();
		assertEquals(1, inizio-fine);
	}
	
	@Test public void testPrezzoCorretto() {
		c.aggiungiPiatto("Pasta al ragù");
		c.aggiungiPiatto("Braciola di maiale");
		c.aggiungiPiatto("Broccoli");
		BigDecimal bigDecimal = new BigDecimal(4.97);
		assertEquals(bigDecimal.setScale(2, RoundingMode.HALF_UP),c.elaboraPrezzo().setScale(2, RoundingMode.HALF_UP));
	}
	
	

}
