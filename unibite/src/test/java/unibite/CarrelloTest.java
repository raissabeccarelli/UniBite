package unibite;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import controller.Carrello;
import generated.tables.Piatti;
import model.Connessione;

class CarrelloTest {
	Carrello c;
	
	public CarrelloTest() {
		c=new Carrello(1);
	}

	//Test che controlla che la matricoa associata al carrello sia corretta
	@Test void testgetMatricola() {
		assertEquals(1, c.getMatricola());
	}
	
	//Test che verifica che la creazione del carrello crei una lista vuota
	@Test void testgetLista() {
		assertTrue(c.getLista().isEmpty());
	}
	
	//verifica che il prezzo iniziale del carrello sia zero
	@Test void testPrezzoIniziale() {
		assertEquals(BigDecimal.ZERO, c.elaboraPrezzo());
	}
	
	//Test che verifica che si possa aggiungere un piatto correttamente al carrello
	@Test void testAggiungiPiatto() {
		//aggiunge piatto al carrello
		c.aggiungiPiatto("Braciola di maiale");
		assertEquals("Braciola di maiale", c.getLista().get(0).getKey());
		
		Map.Entry<String, String> piatto = Map.entry("Braciola di maiale", " ");
		Set<Map.Entry<String, String>> selezione = new HashSet<>();
		selezione.add(piatto);
		c.eliminaPiatto(selezione);
	}
	
	//Test che verifica che si possa aggiungere un primo piatto con formaggio correttamente al carrello
		@Test void testAggiungiPiattoFormaggio() {
			c.aggiungiPiattoConFormaggio("Pasta al ragù");
			assertEquals("Pasta al ragù", c.getLista().getFirst().getKey());
			assertEquals("Aggiungi Formaggio", c.getLista().getFirst().getValue());
			
			Map.Entry<String, String> piatto = Map.entry("Pasta al ragù", "Aggiungi Formaggio");
			Set<Map.Entry<String, String>> selezione = new HashSet<>();
			selezione.add(piatto);
			c.eliminaPiatto(selezione);
		}
		
	  
	//Test che verifica che l'aggiunta di un piatto al carrello diminuisca le porzioni nel database 
	//e che la successiva rimozione di questo piatto aumenti correttamente le porzioni nel database
	@Test void testdiminuisciPiatto() {
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
		
		Map.Entry<String, String> piatto = Map.entry("Braciola di maiale", " ");
		Set<Map.Entry<String, String>> selezione = new HashSet<>();
		selezione.add(piatto);
		c.eliminaPiatto(selezione);
		@NotNull Result<Record1<Integer>> nDop = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Braciola di maiale")).fetch();
		int dopo=nDop.getFirst().value1();
		assertEquals(0, inizio-dopo);
		
	}
	
	//Test che verifica che venga calcolato correttamente il prezzo di un menù
	@Test void testPrezzoCorretto() {
		c.aggiungiPiatto("Pasta al ragù");
		c.aggiungiPiatto("Braciola di maiale");
		c.aggiungiPiatto("Broccoli");
		BigDecimal bigDecimal = new BigDecimal(4.97);
		assertEquals(bigDecimal.setScale(2, RoundingMode.HALF_UP),c.elaboraPrezzo().setScale(2, RoundingMode.HALF_UP));
		
		Map.Entry<String, String> secondo = Map.entry("Braciola di maiale", " ");
		Map.Entry<String, String> primo = Map.entry("Pasta al ragù", " ");
		Map.Entry<String, String> contorno = Map.entry("Broccoli", " ");
		Set<Map.Entry<String, String>> selezione = new HashSet<>();
		selezione.add(primo);
		selezione.add(secondo);
		selezione.add(contorno);
		c.eliminaPiatto(selezione);
	}
	
	

}
