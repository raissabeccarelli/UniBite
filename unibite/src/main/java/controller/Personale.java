package controller;

import org.jooq.DSLContext;

import classidb.Accountpersonale;
import classidb.Accountutenti;
import classidb.Piatti;
import model.Connessione;

public class Personale {
	public String username;		
	public String passwordP;
	
	public Personale(String username, String passwordP) {
		this.username = username;
		this.passwordP = passwordP;
	}
	public Personale() {
		
	}
	
	public String getUsername() {
		return username;
	}

	public String getPasswordP() {
		return passwordP;
	}
	
	public void creaNuovoPiatto(String n, String d, String in, String all, TipoPortata t, String c) {
		float pr=0;
		int po=0;
		Piatto p = new Piatto(n, d, in, all, t, pr, c, po);
	}
	
	public void modificaPiatto() {
		
	}
	
	public boolean login(String username, String pwd) {
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		boolean exists = dslContext.fetchExists(
			        dslContext.selectFrom(Accountpersonale.ACCOUNTPERSONALE).where(Accountpersonale.ACCOUNTPERSONALE.USERNAME.eq(username)
			        		.and(Accountpersonale.ACCOUNTPERSONALE.PASSWORDP.eq(pwd))));
		if(exists) {
			return true;
		}
		return false;	
	 }
}
