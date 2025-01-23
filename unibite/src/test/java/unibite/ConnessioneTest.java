package unibite;

import static org.junit.jupiter.api.Assertions.*;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;

import model.Connessione;

class ConnessioneTest {
	
	Connessione connessione;
	DSLContext dslContext;
	Connessione c;
	
	public ConnessioneTest() {
		connessione = Connessione.getInstance();
		dslContext = connessione.getDslContext();
		c=Connessione.getInstance();
		}

	//Test che verifica che la connessione sia aperta correttamente
	@Test public void testAperturaConnessione() {
		assertNotNull(connessione);
		assertNotNull(dslContext);
		assertFalse(connessione.isClose());
	}
	
	//Test che verifica che la connessione venga chiusa correttamente
	@Test public void testChiusuraConnessione() {
		connessione.close();
		assertTrue(connessione.isClose());
	}

	//Test per verificare che venga aperta solo una connessione (Singleton)
	@Test public void testConn() {
		assertSame(connessione, c);
	}

}
