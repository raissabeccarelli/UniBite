package unibite;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import org.junit.jupiter.api.Test;

import controller.Piatto;
import controller.TipoPortata;
import generated.tables.Piatti;
import model.Connessione;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;

class PiattoTest {
	
	Piatto p;
	private static final Logger LOGGER = LogManager.getLogger(PiattoTest.class);
	
	public PiattoTest() {
		p = new Piatto();
	}

	
	//Test che verifica che ad un piatto di una portata casuale venga associato il prezzo corretto
	@Test void testPrezzo() {
		Random r = new Random();
		int portata = r.nextInt(4)+1;
		
		switch(portata) {
		case 1:  p.setPrezzoUnitario(TipoPortata.PRIMO);
			     float primo = p.getPrezzoUnitario();
			     assertEquals(BigDecimal.valueOf(1.99).setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(primo).setScale(2, RoundingMode.HALF_UP));
			     break;
		case 2:  p.setPrezzoUnitario(TipoPortata.SECONDO);
			     float secondo = p.getPrezzoUnitario();
	             assertEquals(BigDecimal.valueOf(2.69).setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(secondo).setScale(2, RoundingMode.HALF_UP));
	             break;
		case 3:  p.setPrezzoUnitario(TipoPortata.CONTORNO);
			     float contorno = p.getPrezzoUnitario();
	             assertEquals(BigDecimal.valueOf(0.69).setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(contorno).setScale(2, RoundingMode.HALF_UP));
	             break;
		case 4:  p.setPrezzoUnitario(TipoPortata.DOLCEFRUTTA);
			     float dolce = p.getPrezzoUnitario();
	             assertEquals(BigDecimal.valueOf(0.99).setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(dolce).setScale(2, RoundingMode.HALF_UP));
	             break;
	    default: LOGGER.warn("Errore su testPrezzo");
	    	     break;
		}
	}
	
	//test che verifica che si possano settare le porzioni desiderate di un piato in modo corretto
	@Test void testSetPorzioni() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		Result<Record1<Integer>> nIniz = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Braciola di maiale")).fetch();
		int inizio=nIniz.getFirst().value1();
		p.setNumeroPorzioni("Braciola di maiale", inizio+30);
		
		Result<Record1<Integer>> nFin = dslContext.select(Piatti.PIATTI.NUMEROPORZIONI)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq("Braciola di maiale")).fetch();
		int fine=nFin.getFirst().value1();
		assertEquals(30, fine-inizio);
		
		p.setNumeroPorzioni("Braciola di maiale", inizio);
		
	}
	
	
	
	

}
