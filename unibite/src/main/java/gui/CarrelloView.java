package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
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
import controller.StudenteDocente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;


//Visualizzazione del carrello con i piatti inseriti
@PageTitle("Carrello")
@Route("my-view6")
public class CarrelloView extends Composite<VerticalLayout> {

	public CarrelloView() {
		
		StudenteDocente sd = (StudenteDocente) VaadinSession.getCurrent().getAttribute("SDC");		
		Carrello c = (Carrello) VaadinSession.getCurrent().getAttribute("CARRELLO");	
		
		List<Map.Entry<String, String>> piatti = c.getLista();
		Grid<Map.Entry<String, String>> grid = new Grid<>();
		BigDecimal prezzoTot;
		if(sd == null) {
			//Se l'utente non è StudenteDocente, elabora il prezzo intero del carrello
			prezzoTot = c.elaboraPrezzo();			
		}else {
			//Se l'utente è StudenteDocente, elabora il prezzo scontato del carrello (in base alla fascia ISEE)
			prezzoTot = c.elaboraPrezzoScontato(sd.getMatricola());			
		}
		
		//Impostazioni per il layout della view ed instanziazione 
		//delle componenti principali
		
		H1 h1 = new H1();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		Hr hr = new Hr();
		HorizontalLayout layoutRow = new HorizontalLayout();
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		MultiSelectListBox<String> textItems = new MultiSelectListBox<>();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		H4 h4 = new H4();
		HorizontalLayout layoutRow5 = new HorizontalLayout();
		H5 h5 = new H5();
		Paragraph textSmall = new Paragraph();
		Button buttonPrimary = new Button();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		Button buttonPrimary2 = new Button();
		HorizontalLayout layoutRow6 = new HorizontalLayout();
		Button buttonPrimary3 = new Button();
		
		Image image = new Image("images/logo.png", "logo");//Immagine del logo del progetto
		image.setWidth("250px"); // Imposta la larghezza
		image.setHeight("250px"); // Imposta l'altezza
		getContent().setWidth("100%");
		getContent().setHeight("550px");
		
		h1.setText("CARRELLO"); //Titolo della view
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
		String width = "max-content";
		h1.setWidth(width);
		layoutColumn2.setWidthFull();
		
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		String style ="flex-grow";
		layoutColumn2.getStyle().set(style, "1");
		layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn2.setAlignItems(Alignment.START);
		layoutRow.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow);
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.getStyle().set(style, "1");
		layoutRow.setAlignItems(Alignment.CENTER);
		layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutRow2.setHeightFull();
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("75%");
		layoutRow2.getStyle().set(style, "1");
		layoutRow2.setAlignItems(Alignment.CENTER);
		layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
		textItems.setWidth("500px");
		textItems.setHeight("300px");
		
		
		grid.setWidth("600px");
		grid.getStyle().set(style, "0");
		// Imposta la larghezza delle colonne
		grid.addColumn(Map.Entry::getKey)  // Colonna per il nome del piatto
		    .setHeader("Nome Piatto")
		    .setKey("nome");
		    
        grid.addColumn(Map.Entry::getValue)  // Colonna per la descrizione
		    .setHeader("Note")
		    .setKey("note");
		   
		grid.setItems(piatti); //Visualizzazione dei piatti nella grid
		
		
		layoutRow3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set(style, "1");
		layoutRow3.setAlignItems(Alignment.CENTER);
		layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
		
		h4.setText("TOTALE:"); //Prezzo del carrello
		h4.setWidth(width);
		layoutRow5.setHeightFull();
		layoutRow3.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("0px");
		layoutRow5.getStyle().set(style, "1");
		layoutRow5.setAlignItems(Alignment.START);
		layoutRow5.setJustifyContentMode(JustifyContentMode.START);
		h5.setText(prezzoTot.setScale(2, RoundingMode.HALF_UP).toString().concat("€"));
		h5.setWidth(width); //Spazio per mostrare il prezzo del carrello
		
		//Istruzioni per l'eliminazione di un prodotto dal carrello
		textSmall.setText("Per eliminare un prodotto, selezionalo e clicca elimina");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall);
		textSmall.setWidth(width);
		textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
		buttonPrimary.setText("Elimina piatto ❌"); //Bottone che permette di eliminare il piatto selezionato
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
		String setMin = "min-content";
		buttonPrimary.setWidth(setMin);
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		layoutRow4.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("100%");
		layoutRow4.getStyle().set(style, "1");
		layoutRow4.setAlignItems(Alignment.CENTER);
		layoutRow4.setJustifyContentMode(JustifyContentMode.CENTER);
		buttonPrimary2.setText("CONTINUA AD ORDINARE"); //Bottone per tornare alla PortaleordinazioneView
		layoutRow4.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary2);
		buttonPrimary2.setWidth(setMin);
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow6.setHeightFull();
		layoutRow4.setFlexGrow(1.0, layoutRow6);
		layoutRow6.addClassName(Gap.MEDIUM);
		layoutRow6.setWidth("500px");
		layoutRow6.getStyle().set(style, "1");
		layoutRow6.setAlignItems(Alignment.CENTER);
		layoutRow6.setJustifyContentMode(JustifyContentMode.CENTER);
		buttonPrimary3.setText("VAI AL PAGAMENTO"); //Bottone che permette di procedere al pagamento
		layoutRow4.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary3);
		buttonPrimary3.setWidth(setMin);
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		getContent().add(h1);
		getContent().add(layoutColumn2);
		layoutColumn2.add(hr);
		layoutColumn2.add(layoutRow);
		layoutRow.add(layoutRow2);
		layoutRow2.add(image);
		layoutRow2.add(grid);
		layoutColumn2.add(layoutRow3);
		layoutRow3.add(h4);
		layoutRow3.add(h5);
		layoutColumn2.add(textSmall);
		layoutColumn2.add(buttonPrimary);
		getContent().add(layoutRow4);
		layoutRow4.add(buttonPrimary2);
		layoutRow4.add(buttonPrimary3);
		
		//Porta a PortaleordinazioneView
		buttonPrimary2.addClickListener(event -> UI.getCurrent().navigate("my-view4"));
		
		//Eliminazione del piatto selezionato dal carrello e refresh della view
		buttonPrimary.addClickListener(event -> {
			c.eliminaPiatto(grid.getSelectedItems());
			UI.getCurrent().refreshCurrentRoute(isAttached());
		});
		
		//Permette di procedere al pagamento solo se il carrello non è vuoto
		buttonPrimary3.addClickListener(event -> { 
			if(!c.getLista().isEmpty()) {
				if(sd==null) {
					//Porta l'utente non di tipo StudenteDocente a ScontrinoView (può pagare solo alla cassa) 
				    UI.getCurrent().navigate("my-view8");
				}else {
					//Porta l'utente di tipo StudenteDocente a PagamentoView
					UI.getCurrent().navigate("my-view7");
				}	
		}
			
			});
		
		
		
	}

	
}
