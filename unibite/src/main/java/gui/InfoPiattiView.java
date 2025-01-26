package gui;

import java.math.BigDecimal;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Record6;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import generated.tables.*;

import model.Connessione;

@PageTitle("InfoPiatti")
@Route("my-view5")
//Visualizzazione delle informazioni di un piatto selezionato
public class InfoPiattiView extends Composite<VerticalLayout> {

	public InfoPiattiView() {
		
		Record2<String, String> piatto = (Record2<String, String>) VaadinSession.getCurrent().getAttribute("infoPiatto");	
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		List<Record6<String, String, String, String, BigDecimal, String>> result = dslContext.select(Piatti.PIATTI.NOME, Piatti.PIATTI.DESCRIZIONE, Piatti.PIATTI.INGREDIENTI,
				Piatti.PIATTI.ALLERGENI, Piatti.PIATTI.PREZZOUNITARIO,
				Piatti.PIATTI.IMMAGINE)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NOME.eq(piatto.get(Piatti.PIATTI.NOME))).fetch();
		
		//Dichiarazione come variabili delle immagini che verranno utilizzate
		Image pasta = new Image("images/pasta.jpg", "pasta");
		Image riso = new Image("images/riso.jpg", "riso");
		Image carne = new Image("images/carne.jpg", "carne");
		Image pesce = new Image("images/pesce.jpg", "pesce");
		Image contorno = new Image("images/contorno.jpg", "contorno");
		Image dolce = new Image("images/dolce.jpg", "dolce");
		Image frutta = new Image("images/frutta.jpg", "frutta");
		String dimensioneFoto = "150px"; //Settaggi delle dimensioni delle immagini
		pasta.setWidth(dimensioneFoto);
		pasta.setHeight(dimensioneFoto);
		riso.setWidth(dimensioneFoto);
		riso.setHeight(dimensioneFoto);
		carne.setWidth(dimensioneFoto);
		carne.setHeight(dimensioneFoto);
		pesce.setWidth(dimensioneFoto);
		pesce.setHeight(dimensioneFoto);
		contorno.setWidth(dimensioneFoto);
		contorno.setHeight(dimensioneFoto);
		dolce.setWidth(dimensioneFoto);
		dolce.setHeight(dimensioneFoto);
		frutta.setWidth(dimensioneFoto);
		frutta.setHeight(dimensioneFoto);
		
		//Impostazioni per il layout della view ed instanziazione 
		//delle componenti principali
		
		VerticalLayout layoutColumn2 = new VerticalLayout();
		H3 h3 = new H3();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		Hr hr = new Hr();
		Icon icon = new Icon();
		H3 h32 = new H3();
		Paragraph textMedium = new Paragraph();
		H3 h33 = new H3();
		Paragraph textMedium2 = new Paragraph();
		H3 h34 = new H3();
		Paragraph textMedium3 = new Paragraph();
		H3 h35 = new H3();
		Paragraph textMedium4 = new Paragraph();
		
		Button buttonPrimary = new Button();
		buttonPrimary.setText("ESCI");//Porta alla PortaleordinazioniView
		buttonPrimary.setWidth("min-content");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		getContent().setWidth("100%");
		String style = "flex-grow";
		getContent().getStyle().set(style, "1");
		
		//Estrae dal db le info richieste e le mostra
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set(style, "1");
		h3.setText(result.get(0).get(Piatti.PIATTI.NOME)); //Nome del piatto
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, h3);
		String maxWidth = "max-content";
		h3.setWidth(maxWidth);
		layoutColumn3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set(style, "1");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn3.setAlignItems(Alignment.CENTER);
		icon.setIcon("lumo:user");
		icon.setSize("300px");
		h32.setText("Descrizione");
		h32.setWidth(maxWidth);
		textMedium.setText(result.get(0).get(Piatti.PIATTI.DESCRIZIONE)); //Descrizione del piatto
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, textMedium);
		textMedium.setWidth(maxWidth);
		String font = "font-size";
		String size = "var(--lumo-font-size-m)";
		textMedium.getStyle().set(font, size);
		h33.setText("Ingredienti");
		h33.setWidth(maxWidth);
		textMedium2.setText(result.get(0).get(Piatti.PIATTI.INGREDIENTI)); //Ingredienti presenti nel piatto
		textMedium2.setWidth(maxWidth);
		textMedium2.getStyle().set(font, size);
		h34.setText("Allergeni");
		h34.setWidth(maxWidth);
		textMedium3.setText(result.get(0).get(Piatti.PIATTI.ALLERGENI)); //Allergeni presenti nel piatto
		textMedium3.setWidth(maxWidth);
		textMedium3.getStyle().set(font, size);
		h35.setText("Prezzo");
		h35.setWidth(maxWidth);
		textMedium4.setText(result.get(0).get(Piatti.PIATTI.PREZZOUNITARIO).toString()); //Prezzo di una porzione del piatto
		textMedium4.setWidth(maxWidth);
		textMedium4.getStyle().set(font, size);
		getContent().add(layoutColumn2);
		layoutColumn2.add(h3);
		layoutColumn2.add(layoutColumn3);
		layoutColumn3.add(hr);
		//Impostazione del piatto tra quelle definite in precedenza
		if(result.get(0).get(Piatti.PIATTI.IMMAGINE).equals("pasta")) {
			layoutColumn3.add(pasta); //Piatto di pasta
		}else if(result.get(0).get(Piatti.PIATTI.IMMAGINE).equals("riso")){
			layoutColumn3.add(riso); //Piatto di riso
		}else if(result.get(0).get(Piatti.PIATTI.IMMAGINE).equals("carne")) {
			layoutColumn3.add(carne); //Piatto a base di carne
		}else if(result.get(0).get(Piatti.PIATTI.IMMAGINE).equals("pesce")) {
			layoutColumn3.add(pesce); //Piatto a base di pesce
		}else if(result.get(0).get(Piatti.PIATTI.IMMAGINE).equals("contorno")) {
			layoutColumn3.add(contorno); //Portata di contorno
		}else if(result.get(0).get(Piatti.PIATTI.IMMAGINE).equals("dolce")) {
			layoutColumn3.add(dolce); //Portata di dolce
		}else {
			layoutColumn3.add(frutta); //Portata di frutta
		}
		layoutColumn3.add(h32);
		layoutColumn3.add(textMedium);
		layoutColumn3.add(h33);
		layoutColumn3.add(textMedium2);
		layoutColumn3.add(h34);
		layoutColumn3.add(textMedium3);
		layoutColumn3.add(h35);
		layoutColumn3.add(textMedium4);
		layoutColumn3.add(buttonPrimary);
		
		//Porta a PortaleordinazioneView
		buttonPrimary.addClickListener(event -> UI.getCurrent().navigate("my-view4"));
	}
}
