package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

	
public class Connessione {
	public static String DB_REL_FILE = "..\\unibite\\src\\main\\resources\\UNIBitedb.db";
	public static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;
	
	public void apriConnessione() {
		try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // Crea un DSLContext jOOQ
            DSLContext create = DSL.using(conn);

            // Esegui una query con jOOQ (esempio di selezione dalla tabella 'utenti')
            create.select()
                  .from("Piatti")
                  .fetch()
                  .forEach(record -> System.out.println(record));
        } catch (Exception e) {
            e.printStackTrace();
        }
	
}}


