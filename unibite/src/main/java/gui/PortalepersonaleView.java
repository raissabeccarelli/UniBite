package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.*;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import controller.Personale;
import controller.Piatto;
import java.util.List;

import org.jooq.Record2;
import org.springframework.scheduling.annotation.Scheduled;

@PageTitle("Portale personale")
@Route("my-view9")
public class PortalepersonaleView extends Composite<VerticalLayout> {
	
	public PortalepersonaleView() {
		HorizontalLayout layoutRow = new HorizontalLayout();
		Image image = new Image("images/logo.png", "logo");
		image.setWidth("100px"); // Imposta la larghezza
		image.setHeight("100px"); // Imposta l'altezza
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		
		//mette un intestazione
		H3 h3 = new H3();
		
		Button buttonPrimary = new Button(); //creazione bottone poi utilizzato per il logout
		Paragraph textSmall = new Paragraph();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		Button buttonPrimary2 = new Button(); //creazione bottone poi utilizzato per aggiungere nuove ricette
		HorizontalLayout layoutRow6 = new HorizontalLayout();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		
		//crea una lista con due attributi (nome del piatto e quantità disponibili) presi dal database tramite il 
		//metodo cerca piatti, da mostrare a schermo
		List<Record2<String, Integer>> piatti = Piatto.cercaPiatti();
		//creazione di una griglia su cui poi verrà proiettata la lista sopra
		Grid<Record2<String, Integer>> grid = new Grid<>();
        

		HorizontalLayout layoutRow5 = new HorizontalLayout();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		//field per poter inserire le nuove quantità di porzioni disponibili, come interi
		IntegerField numberField = new IntegerField();
		//bottone che prende le quantità inserite sopra e le inserisce nel db
		Button buttonPrimary3 = new Button();
		VerticalLayout layoutColumn4 = new VerticalLayout();
		//bottone "Elimina piatto", per settare le porzioni di un piatto a 0
		Button buttonPrimary4 = new Button();
		getContent().setWidth("100%");
		
		//variabile che indica quanto devono espandersi gli elementi
		String style = "flex-grow";
		//variabile che imposta la dimensione minima del contenitore
		String dim = "min-content";
		
		getContent().getStyle().set(style, "1");
		layoutRow.setWidthFull(); //imposta la larghezza al massimo
		getContent().setFlexGrow(1.0, layoutRow); //fa in modo che si espanda all'interno di layoutRow
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.setHeight(dim); //imposta l'altezza al minimo
		layoutRow.setAlignItems(Alignment.CENTER); //allinea verticalmente al centro
		layoutRow.setJustifyContentMode(JustifyContentMode.CENTER); //allinea orizzontalmente al centro
		
		layoutRow2.setHeightFull(); //imposta layoutRow2 alla massima altezza
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%"); //imposta alla massima larghezza
		layoutRow2.setHeight(dim); //imposta alla minima altezza
		h3.setText("MODIFICA IL MENU' DEL GIORNO"); //setta il testo tra () nell'intestazione
		h3.setWidth("max-content"); //imposta la larghezza del testo al massimo
		buttonPrimary.setText("LOGOUT"); //setta il testo sul bottone
		buttonPrimary.setWidth(dim); //imposta la dimensione del bottone al minimo 
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //rende il bottone un pulsante primario
		//setta il testo da vedere a schermo
		textSmall.setText(
				"Per aggiungere un piatto al menù, selezionalo e clicca \"Aggiungi quantità\". "
				+ "Per eliminarlo dal menù, selezionalo e clicca \"Elimina piatto\". "
				+ "Per aggiungere una ricetta seleziona \"Aggiungi ricetta\". "
				+ "Ricorda che devono essere disponibili almeno 3 piatti diversi per ogni categoria");
		textSmall.setWidth("100%"); //imposta la largezza del testo al massimo
		textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)"); 
		layoutRow3.setWidthFull(); //imposta la larghezza al massimo
		getContent().setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setHeight(dim); //imposta altezza al minimo
		layoutRow3.setAlignItems(Alignment.START); //allinea gli elementi di layouutRow3 all'inizio verticalmente
		layoutRow3.setJustifyContentMode(JustifyContentMode.START); //allinea gli elementi all'inizio orizzontalmente
		buttonPrimary2.setText("Aggiungi ricetta"); //setta il testo dell bottone
		buttonPrimary2.setWidth(dim); //setta la dimensione del bottone al minimo
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //rende il bottone un bottone primario
		layoutRow6.setHeightFull(); //imposta la larghezza al massimo
		layoutRow3.setFlexGrow(1.0, layoutRow6);
		layoutRow6.addClassName(Gap.MEDIUM);
		layoutRow6.getStyle().set(style, "1");
		layoutRow6.getStyle().set(style, "1");
		layoutColumn2.setWidthFull(); //imposta la larghezza al massimo
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.getStyle().set(style, "1");
		layoutRow4.setWidthFull(); //imposta la larghezza al massimo
		layoutColumn2.setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("100%");
		layoutRow4.getStyle().set(style, "1");

		//imposta la larghezza della griglia
		grid.setWidth("5000px");
		// Imposta le colonne della Grid
		grid.addColumn(record -> record.value1()) // NOME
				.setHeader("Nome Piatto").setKey("nome");

		grid.addColumn(record -> record.value2()) // NUMEROPORZIONI
				.setHeader("Numero Porzioni").setKey("numeroPorzioni");

		// Imposta i dati da visualizzare nella Grid
		grid.setItems(piatti);

		layoutRow5.setHeightFull(); //imposta l'altezza al massimo
		layoutRow4.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("100%"); //imposta la larghezza al massimo
		layoutRow5.getStyle().set(style, "1");
		layoutColumn3.setHeightFull(); //imposta l'altezza al massimo
		layoutRow5.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%"); //imposta la larghezza al massimo
		layoutColumn3.getStyle().set(style, "1");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.START); //mette gli elementi di layoutColumn3 all'inizio orizzontalmente
		layoutColumn3.setAlignItems(Alignment.CENTER); //mette gli elementi in centro verticalmente
		numberField.setLabel("Inserisci porzioni"); //setta il titolo del field
		numberField.setWidth("179px"); //imposta la dimensione
		buttonPrimary3.setText("Imposta il numero di porzioni"); //imposta il testo del bottone
		buttonPrimary3.setWidth(dim); //imposta la diemnsione del bottone
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //imposta il bottone come bottone primario
		layoutColumn4.setWidthFull(); //imposta la larghezza al massimo
		layoutColumn3.setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setHeight("20px"); //imposta l'altezza
		buttonPrimary4.setText("Elimina piatto ❌"); //setta il testo del bottone
		buttonPrimary4.setWidth("179px"); //imposta la diemnsione del bottone
		buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //mette il bottone come bottone primario
		getContent().add(layoutRow); //aggiunge alla vista il layoutRow
		layoutRow.add(image); //aggiunge al layoutRow l'immagine
		layoutRow.add(layoutRow2); //aggiunge al layoutRow
		layoutRow2.add(h3);
		layoutRow.add(buttonPrimary);
		//aggiunge alla vista 
		getContent().add(textSmall);
		getContent().add(layoutRow3);
		//aggiunge al layoutRow3
		layoutRow3.add(buttonPrimary2);
		layoutRow3.add(layoutRow6);
		//aggiunge alla vista
		getContent().add(layoutColumn2);
		//aggiunge ai vari layout
		layoutColumn2.add(layoutRow4);
		layoutRow4.add(grid);
		layoutRow4.add(layoutRow5);
		layoutRow5.add(layoutColumn3);
		layoutColumn3.add(numberField);
		layoutColumn3.add(buttonPrimary3);
		layoutColumn3.add(layoutColumn4);
		layoutColumn3.add(buttonPrimary4);
		
		//gestisce il click del bottone 
		buttonPrimary2.addClickListener(event -> UI.getCurrent().navigate("my-view10"));
		buttonPrimary.addClickListener(event -> {
			
			UI.getCurrent().navigate("");
		});
		
		Personale p = new Personale();
		buttonPrimary3.addClickListener(event -> {
			p.aggiungiPorzioni(grid.getSelectedItems(), numberField.getValue());
			UI.getCurrent().refreshCurrentRoute(isAttached());
		});
		buttonPrimary4.addClickListener(event -> {
			
			p.eliminaPiatto(grid.getSelectedItems());
			UI.getCurrent().refreshCurrentRoute(isAttached());
		});
		
		UI.getCurrent().getPage().executeJs("setInterval(() => location.reload(), 10000);");

		
	}
	

}
