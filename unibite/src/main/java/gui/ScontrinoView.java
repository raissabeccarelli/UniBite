package gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import controller.Carrello;
import controller.Scontrino;

@PageTitle("Scontrino")
@Route("my-view8")
public class ScontrinoView extends Composite<VerticalLayout> {
	private static final Logger logger = LogManager.getLogger(ScontrinoView.class);
	public ScontrinoView() {
	    // Istanziazione degli oggetti principali
	    Scontrino sc = new Scontrino(); // Oggetto Scontrino per ottenere i dati del numero seriale
	    Carrello c = (Carrello) VaadinSession.getCurrent().getAttribute("CARRELLO"); // Recupera il carrello dalla sessione

	    // Layout e componenti
	    HorizontalLayout layoutRow2 = new HorizontalLayout(); // Layout per il messaggio principale
	    H1 h1 = new H1(); // Titolo principale
	    H6 h6 = new H6(); // Sottotitolo
	    HorizontalLayout layoutRow = new HorizontalLayout(); // Layout per il numero scontrino
	    H4 h4 = new H4(); // Etichetta "N°:"
	    H4 h42 = new H4(); // Numero seriale dello scontrino
	    VerticalLayout layoutColumn2 = new VerticalLayout(); // Layout per il logo
	    Image image = new Image("images/logo.png", "logo"); // Immagine del logo

	    // Configurazione del logo
	    image.setWidth("175px"); // Imposta la larghezza
	    image.setHeight("175px"); // Imposta l'altezza

	    // Configurazione dello stile del contenitore principale
	    getContent().setWidth("100%");
	    getContent().getStyle().set("flex-grow", "1");

	    // Configurazione del layoutRow2 (messaggio principale)
	    layoutRow2.setWidthFull();
	    layoutRow2.setWidth("100%");
	    layoutRow2.setHeight("150px");
	    layoutRow2.addClassName(Gap.MEDIUM);
	    getContent().setFlexGrow(1.0, layoutRow2);

	    // Configurazione del titolo principale (H1)
	    h1.setText("GRAZIE E BUON PRANZO!");
	    h1.setWidth("max-content");
	    getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);

	    // Configurazione del sottotitolo (H6)
	    h6.setText("VAI IN CASSA CON IL TUO SCONTRINO");
	    h6.setWidth("max-content");
	    getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h6);

	    // Configurazione del layoutRow (sezione numero scontrino)
	    layoutRow.setWidthFull();
	    layoutRow.setWidth("100%");
	    layoutRow.setHeight("25px");
	    layoutRow.setAlignItems(Alignment.START);
	    layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
	    layoutRow.addClassName(Gap.MEDIUM);

	    // Configurazione del numero seriale dello scontrino
	    h4.setText("N°:"); // Etichetta "N°:"
	    h4.setWidth("max-content");
	    h42.setText("" + sc.getNumeroSeriale()); // Numero seriale dello scontrino
	    h42.setWidth("max-content");

	    // Configurazione del layoutColumn2 (logo)
	    layoutColumn2.setWidthFull();
	    layoutColumn2.setWidth("100%");
	    layoutColumn2.setHeight("150px");
	    layoutColumn2.setJustifyContentMode(JustifyContentMode.CENTER);
	    layoutColumn2.setAlignItems(Alignment.CENTER);

	    // Aggiunta dei componenti al contenitore principale
	    getContent().add(layoutRow2); // Layout per il messaggio principale
	    getContent().add(h1); // Titolo principale
	    getContent().add(h6); // Sottotitolo
	    getContent().add(layoutRow); // Layout per il numero scontrino
	    layoutRow.add(h4); // Etichetta "N°:"
	    layoutRow.add(h42); // Numero seriale dello scontrino
	    getContent().add(layoutColumn2); // Layout per il logo
	    layoutColumn2.add(image); // Aggiunta del logo

	    // Logging per il numero scontrino e il contenuto del carrello
	    logger.info("Numero scontrino: " + sc.getNumeroSeriale());
	    logger.info("Ordine: " + c.getLista());

	    // Reindirizzamento automatico dopo 5 secondi
	    UI.getCurrent().getPage().executeJs(
	        "setTimeout(() => window.location.href='', 5000);"
	    );
	}

}
