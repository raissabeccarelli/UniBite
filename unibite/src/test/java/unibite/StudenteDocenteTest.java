package unibite;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.junit.jupiter.api.Test;

import controller.Carrello;
import controller.FasciaIsee;
import controller.StudenteDocente;
import generated.tables.Accountutenti;
import generated.tables.Piatti;
import model.Connessione;

class StudenteDocenteTest {
	StudenteDocente s;
	public StudenteDocenteTest() {
		s=new StudenteDocente();
	}
	
	//Verifica che il login avvenga correttamente
	@Test void loginTest() {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//verifico se trova la matricola
		boolean result = dslContext.fetchExists(dslContext.selectFrom(Accountutenti.ACCOUNTUTENTI).where(
				Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(1086785)));
		assertTrue(result);
		//verifico se a quella matricola è associata la password corretta
		assertTrue(s.login(1086785, "Raissa1234"));
	}
	
	//Verifica che il conto virtuale sia pari a 0 quando creo un nuovo studente
	@Test void contoVirtualeTest() {
		StudenteDocente stu=new StudenteDocente(1088068, "Davi", "Davide", "Carissoni", "d.carissoni@studenti.unibg.it",FasciaIsee.A, 0);
		assertEquals(0, stu.getContoVirtuale(stu.getMatricola()));
		
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		dslContext.deleteFrom(Accountutenti.ACCOUNTUTENTI).where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(stu.getMatricola())).execute();
		
	}


}
