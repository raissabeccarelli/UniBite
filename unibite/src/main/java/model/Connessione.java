package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.impl.DSL;

import classidb.Accountutenti;
import classidb.Piatti;
import controller.Piatto;

public class Connessione {
	public static String DB_REL_FILE = "..\\unibite\\src\\main\\resources\\UNIBitedb.db";
	public static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;

	private static Connessione instance;
	DSLContext dslContext;
	Connection conn;

	private Connessione() {
		try {
			this.conn = DriverManager.getConnection(DB_URL);
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
