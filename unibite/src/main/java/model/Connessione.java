package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public final class Connessione {
	public final static String DB_REL_FILE = "..\\unibite\\src\\main\\resources\\UNIBitedb.db";
	public final static String URL_DB = "jdbc:sqlite:" + DB_REL_FILE;

	private static Connessione instance;
	DSLContext dslContext;
	Connection conn;

	private Connessione() {
		try {
			this.conn = DriverManager.getConnection(URL_DB);
			this.dslContext = DSL.using(conn);
		} catch (SQLException e) {
			throw new RuntimeException("Errore durante la connessione al database: " + e.getMessage(), e);
		}
	}

	public static synchronized Connessione getInstance() {
		if (instance == null) {
			instance = new Connessione();
		}
		return instance;
	}

	public DSLContext getDslContext() {
		return dslContext;
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			dslContext = null;
			instance = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
	    return conn;
	}
	
	public boolean isClose() {
	    try {
	        // Verifica se la connessione è chiusa
	        return conn == null || conn.isClosed();
	    } catch (SQLException e) {
	        // Gestisce eventuali eccezioni
	        throw new RuntimeException("Errore durante il controllo dello stato della connessione: " + e.getMessage(), e);
	    }
	}

}
