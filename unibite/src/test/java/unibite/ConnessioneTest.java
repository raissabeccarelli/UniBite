package unibite;

import static org.junit.jupiter.api.Assertions.*;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;

import model.Connessione;

class ConnessioneTest {
	Connessione connessione;
	DSLContext dslContext;
	
	public ConnessioneTest() {
		connessione = Connessione.getInstance();
		dslContext = connessione.getDslContext();
	}

	@Test public void testAperturaConnessione() {
		assertNotNull(connessione);
		assertNotNull(dslContext);
		assertFalse(connessione.isClose());
	}
	
	@Test public void testChiusuraConnessione() {
		connessione.close();
		assertTrue(connessione.isClose());
	}


}
