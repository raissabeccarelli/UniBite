package unibite;

import static org.junit.jupiter.api.Assertions.*;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;

import controller.StudenteDocente;
import generated.tables.Accountutenti;
import model.Connessione;

class StudenteDocenteTest {
	StudenteDocente s;
	public StudenteDocenteTest() {
		s=new StudenteDocente();
	}
	
	//verifica che il login avvenga correttamente
	@Test public void loginTest() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//verifico se trova la matricola
		boolean result = dslContext.fetchExists(dslContext.selectFrom(Accountutenti.ACCOUNTUTENTI).where(
				Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(1086785)));
		assertTrue(result);
		//verifico se a quella matricola è associata la password corretta
		assertTrue(s.login(1086785, "Raissa1234"));
	}
	
	//verifica che il conto virtuale sia pari a 0 quando creo un nuovo studente
	@Test public void contoVirtualeTest() {
		//abbiamo creato uno studente con matricola 1088068 per verificare 
		//che appena creato il conto fosse settato direttamente a 0
		assertEquals(0, s.getContoVirtuale(1088068));
	}


}
