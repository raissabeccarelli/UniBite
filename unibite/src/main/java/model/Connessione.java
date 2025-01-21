package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class Connessione {
	public final static String dbRelFile = "..\\unibite\\src\\main\\resources\\UNIBitedb.db";
	public final static String urlDb = "jdbc:sqlite:" + dbRelFile;

	private static Connessione instance;
	DSLContext dslContext;
	Connection conn;

	private Connessione() {
		try {
			this.conn = DriverManager.getConnection(urlDb);
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

}
