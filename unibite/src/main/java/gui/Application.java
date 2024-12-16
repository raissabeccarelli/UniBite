package gui;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

import model.Connessione;

import org.jooq.DSLContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 * 
 *
 */
@SpringBootApplication
@Theme(value = "unibite")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
    	
       Connessione connessione = Connessione.getInstance();
       DSLContext context = connessione.getDslContext();

       SpringApplication.run(Application.class, args);
    	    	
       connessione.close();       
    }
}
