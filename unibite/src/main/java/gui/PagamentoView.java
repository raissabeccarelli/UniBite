package gui;

import org.jooq.DSLContext;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
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
import generated.tables.Accountutenti;
import model.Connessione;

@PageTitle("Pagamento")
@Route("my-view7")
public class PagamentoView extends Composite<VerticalLayout> {

	public PagamentoView() {
		//prende lo stuudente che gli viene ppassato dalla view precedente
		StudenteDocente sd = (StudenteDocente) VaadinSession.getCurrent().getAttribute("SDC");	
		//prende il carrello che gli viene passato dalla view precedente
		Carrello c = (Carrello) VaadinSession.getCurrent().getAttribute("CARRELLO");	
		//crea le intestazioni
		H1 h1 = new H1();
		H4 h4 = new H4();
		H4 h6 = new H4();
		//crea il separatore
		Hr hr = new Hr();
		Paragraph textSmall = new Paragraph(); //crea un paragrafo di testo
		//crea i vari layout
		VerticalLayout layoutColumn2 = new VerticalLayout();
		HorizontalLayout layoutRow = new HorizontalLayout();
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		HorizontalLayout layoutRow5 = new HorizontalLayout();
		//crea i bottoni
		Button buttonPrimary = new Button();
		Button buttonPrimary2 = new Button();
		
		getContent().setWidth("100%"); //imposta la larghezza al massimo
		//indica agli elementi quanto espandersi
		String style = "flex-grow";
		
		getContent().getStyle().set(style, "1");
		h1.setText("PAGAMENTO"); //setta il testo dell'intestazione
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1); //allinea al centro
		//imosta la dimensione minima dei contenitori
		String width = "max-content";
		h1.setWidth(width); //imposta la dimensione massima
		//setta il testo
		textSmall.setText("Scegli se pagare in cassa oppure se addebitare il pranzo sul tuo conto virtuale");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textSmall); //allinea al centro il testo sopra
		textSmall.setWidth(width); //imposta la dimensione massima
		textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
		layoutColumn2.setWidthFull(); //imposta la larghezza al massimo
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.getStyle().set(style, "1");
		layoutRow.setWidthFull(); //imposta la larghezza al massimo
		layoutColumn2.setFlexGrow(1.0, layoutRow);
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.getStyle().set(style, "1");
		layoutRow2.setHeightFull(); //imposta l'altezza al massimo
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%"); //imposta la larghezza al massimo
		layoutRow2.getStyle().set(style, "1");
		layoutRow2.setAlignItems(Alignment.CENTER); //allinea gli elementi al centro orizzontalemnte
		layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER); //allinea gli elementi al centro verticalmente
		layoutRow4.setHeightFull(); //imposta l'altezza al massimo
		layoutRow2.setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("780px"); //imposta la larghezza
		layoutRow4.getStyle().set(style, "1");
		h4.setText("Credito virtuale:"); //setta il testo dell'intestazione
		layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h4); //centra l'intestazione
		h4.setWidth(width); //imposta la dimensione massima
		h6.setText(sd.getContoVirtuale(sd.getMatricola())+"€"); //setta il testo dell'intestazione utilizzando un metodo
		layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h6); //allinea centralmente
		h6.setWidth(width); //imposta la larghezza al massimo
		layoutRow3.setWidthFull(); //imposta la larghezza al massimo
		layoutColumn2.setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.getStyle().set(style, "1");
		layoutRow3.setAlignItems(Alignment.CENTER); //allinea gli elementi inn centro orizzontalmente
		layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER); //allinea gli elementi in centro verticalmente
		buttonPrimary.setText("PAGA IN CASSA"); //setta il testo del bottone
		layoutRow3.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary); //allinea al centro il bottone
		
		String dimensioneBottone= "300px"; //setta le dimensioni del bottone
		buttonPrimary.setWidth(dimensioneBottone);
		buttonPrimary.setHeight(dimensioneBottone);
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //aggiunge il bottone ai bottoni primari
		layoutRow5.setHeightFull(); //imposta l'altezza al massimo
		layoutRow3.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("200px"); //imposta la larghezza 
		layoutRow5.getStyle().set(style, "1");
		buttonPrimary2.setText("PAGA COL CREDITO VIRTUALE"); //setta il testo del bottone
		layoutRow3.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary2); //centra il bottone nel layout
		buttonPrimary2.setWidth(dimensioneBottone); 
		buttonPrimary2.setHeight(dimensioneBottone);
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //aggiunge il bottone ai bottoni primari
		//aggiunge alla view
		getContent().add(h1);
		getContent().add(hr);
		getContent().add(textSmall);
		getContent().add(layoutColumn2);
		//aggiunge ai layout
		layoutColumn2.add(layoutRow);
		layoutRow.add(layoutRow2);
		layoutRow2.add(h4);
		layoutRow2.add(h6);
		layoutColumn2.add(layoutRow3);
		layoutRow3.add(buttonPrimary);
		layoutRow3.add(buttonPrimary2);
		
		
		//bottone vai in cassa
		buttonPrimary.addClickListener(event -> UI.getCurrent().navigate("my-view8"));
		//bottone pagamento virtuale
		buttonPrimary2.addClickListener(event -> {
			Connessione connessione = Connessione.getInstance();
			DSLContext dslContext = connessione.getDslContext();
			dslContext.update(Accountutenti.ACCOUNTUTENTI).set(Accountutenti.ACCOUNTUTENTI.CONTO,Accountutenti.ACCOUNTUTENTI.CONTO.add(c.elaboraPrezzoScontato(sd.getMatricola())))
			.where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(sd.getMatricola())).execute();
			UI.getCurrent().navigate("my-view8");});
	}
}
