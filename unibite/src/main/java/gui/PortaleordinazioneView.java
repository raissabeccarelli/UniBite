package gui;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import generated.tables.*;
import controller.Carrello;
import controller.CarrelloObserver;

import controller.StudenteDocente;
import model.Connessione;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@PageTitle("Portale ordinazione")
@Route("my-view4")
public class PortaleordinazioneView extends Composite<VerticalLayout> implements CarrelloObserver{
	private static final Logger logger = LogManager.getLogger(PortaleordinazioneView.class);
	private Carrello c = (Carrello) VaadinSession.getCurrent().getAttribute("CARRELLO");	
	
	@Override
    public void onPiattoAggiunto(String nomePiatto) {
		
        String messaggio = "È stato aggiunto il piatto: " + nomePiatto;
      Notification.show(messaggio);
    
	}
	
	public PortaleordinazioneView() {
		
		//lista dei primi piatti
		List<Record2<String,String>> primi=primiPiatti();
		Record2<String, String> primi1 = primi.get(0);
		Record2<String, String> primi2 = primi.get(1);
		Record2<String, String> primi3 = primi.get(2);
		String p= "pasta";
		String r = "riso";
		Image pasta = new Image("images/pasta.jpg", p);
		Image pasta2 = new Image("images/pasta.jpg",p);
		Image pasta3 = new Image("images/pasta.jpg", p);
		Image riso = new Image("images/riso.jpg", r);
		Image riso2 = new Image("images/riso.jpg", r);
		Image riso3 = new Image("images/riso.jpg", r);
		
		//lista dei secondi piatti
		List<Record2<String,String>> secondi=secondiPiatti();
		Record2<String, String> secondi1 = secondi.get(0);
		Record2<String, String> secondi2 = secondi.get(1);
		Record2<String, String> secondi3 = secondi.get(2);
		String ca = "carne";
		String pe = "pesce";
		Image carne = new Image("images/carne.jpg", ca);
		Image carne2 = new Image("images/carne.jpg", ca);
		Image carne3 = new Image("images/carne.jpg", ca);
		Image pesce = new Image("images/pesce.jpg", pe);
		Image pesce2 = new Image("images/pesce.jpg", pe);
		Image pesce3 = new Image("images/pesce.jpg", pe);
		
		//lista dei contorni
		String co = "contorno";
		List<Record2<String,String>> contorni=contorni();
		Record2<String, String> contorni1 = contorni.get(0);
		Record2<String, String> contorni2 = contorni.get(1);
		Record2<String, String> contorni3 = contorni.get(2);
		Image contorno = new Image("images/contorno.jpg", co);
		Image contorno2 = new Image("images/contorno.jpg", co);
		Image contorno3 = new Image("images/contorno.jpg", co);
		
		//lista dei dolci e della frutta
		List<Record2<String,String>> dolciFrutta=dolciFrutta();
		Record2<String, String> dolciFrutta1 = dolciFrutta.get(0);
		Record2<String, String> dolciFrutta2 = dolciFrutta.get(1);
		Record2<String, String> dolciFrutta3 = dolciFrutta.get(2);
		String d = "dolce";
		String f = "frutta";
		Image dolce = new Image("images/dolce.jpg", d);
		Image dolce2 = new Image("images/dolce.jpg", d);
		Image dolce3 = new Image("images/dolce.jpg", d);
		Image frutta = new Image("images/frutta.jpg", f);
		Image frutta2 = new Image("images/frutta.jpg", f);
		Image frutta3 = new Image("images/frutta.jpg", f);
	
		
		HorizontalLayout layoutRow = new HorizontalLayout();
		
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		H3 h3 = new H3();
		Button buttonPrimary = new Button();
		Button buttonPrimary2 = new Button();
		H1 h1 = new H1();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		Paragraph textSmall = new Paragraph();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		
		Button buttonSecondary = new Button();
		Checkbox checkbox = new Checkbox();
		Button buttonPrimary3 = new Button();
		VerticalLayout layoutColumn4 = new VerticalLayout();
		Paragraph textSmall2 = new Paragraph();
		VerticalLayout layoutColumn5 = new VerticalLayout();
		
		Button buttonSecondary2 = new Button();
		Checkbox checkbox2 = new Checkbox();
		Button buttonPrimary4 = new Button();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		VerticalLayout layoutColumn6 = new VerticalLayout();
		Paragraph textSmall3 = new Paragraph();
		HorizontalLayout layoutRow5 = new HorizontalLayout();
		
		Button buttonSecondary3 = new Button();
		Checkbox checkbox3 = new Checkbox();
		Button buttonPrimary5 = new Button();
		Hr hr = new Hr();
		Hr hr2 = new Hr();
		H1 h12 = new H1();
		HorizontalLayout layoutRow6 = new HorizontalLayout();
		VerticalLayout layoutColumn7 = new VerticalLayout();
		Paragraph textSmall4 = new Paragraph();
		VerticalLayout layoutColumn8 = new VerticalLayout();
		
		Button buttonSecondary4 = new Button();
		Button buttonPrimary6 = new Button();
		VerticalLayout layoutColumn9 = new VerticalLayout();
		Paragraph textSmall5 = new Paragraph();
		VerticalLayout layoutColumn10 = new VerticalLayout();
		
		Button buttonSecondary5 = new Button();
		Button buttonPrimary7 = new Button();
		HorizontalLayout layoutRow7 = new HorizontalLayout();
		VerticalLayout layoutColumn11 = new VerticalLayout();
		Paragraph textSmall6 = new Paragraph();
		VerticalLayout layoutColumn12 = new VerticalLayout();
		
		Button buttonSecondary6 = new Button();
		Button buttonPrimary8 = new Button();
		H1 h13 = new H1();
		HorizontalLayout layoutRow8 = new HorizontalLayout();
		VerticalLayout layoutColumn13 = new VerticalLayout();
		Paragraph textSmall7 = new Paragraph();
		VerticalLayout layoutColumn14 = new VerticalLayout();
		
		Button buttonSecondary7 = new Button();
		Button buttonPrimary9 = new Button();
		VerticalLayout layoutColumn15 = new VerticalLayout();
		Paragraph textSmall8 = new Paragraph();
		VerticalLayout layoutColumn16 = new VerticalLayout();
		
		Button buttonSecondary8 = new Button();
		Button buttonPrimary10 = new Button();
		HorizontalLayout layoutRow9 = new HorizontalLayout();
		VerticalLayout layoutColumn17 = new VerticalLayout();
		Paragraph textSmall9 = new Paragraph();
		VerticalLayout layoutColumn18 = new VerticalLayout();
		
		Button buttonSecondary9 = new Button();
		Button buttonPrimary11 = new Button();
		H1 h14 = new H1();
		VerticalLayout layoutColumn19 = new VerticalLayout();
		HorizontalLayout layoutRow10 = new HorizontalLayout();
		VerticalLayout layoutColumn20 = new VerticalLayout();
		Paragraph textSmall10 = new Paragraph();
		VerticalLayout layoutColumn21 = new VerticalLayout();
		
		Button buttonSecondary10 = new Button();
		Button buttonPrimary12 = new Button();
		VerticalLayout layoutColumn22 = new VerticalLayout();
		Paragraph textSmall11 = new Paragraph();
		VerticalLayout layoutColumn23 = new VerticalLayout();
		
		Button buttonSecondary11 = new Button();
		Button buttonPrimary13 = new Button();
		HorizontalLayout layoutRow11 = new HorizontalLayout();
		VerticalLayout layoutColumn24 = new VerticalLayout();
		Paragraph textSmall12 = new Paragraph();
		VerticalLayout layoutColumn25 = new VerticalLayout();
		
		Button buttonSecondary12 = new Button();
		Button buttonPrimary14 = new Button();
		Image logo = new Image("images/logo.png", "logo");
		
		
		
		
		logo.setWidth("125px"); // Imposta la larghezza
		logo.setHeight("125px"); // Imposta l'altezza
		getContent().setWidth("100%");
		getContent().setHeight("450px");
		layoutRow.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow);
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		String style = "flex-grow";
		String wid = "min-content";
		layoutRow.getStyle().set(style, "1");
		
		String dim= "150px";
		pasta.setWidth(dim);
		pasta.setHeight(dim);
		pasta2.setWidth(dim);
		pasta2.setHeight(dim);
		pasta3.setWidth(dim);
		pasta3.setHeight(dim);
		riso.setWidth(dim);
		riso.setHeight(dim);
		riso2.setWidth(dim);
		riso2.setHeight(dim);
		riso3.setWidth(dim);
		riso3.setHeight(dim);
		carne.setWidth(dim);
		carne.setHeight(dim);
		carne2.setWidth(dim);
		carne2.setHeight(dim);
		carne3.setWidth(dim);
		carne3.setHeight(dim);
		pesce.setWidth(dim);
		pesce.setHeight(dim);
		pesce2.setWidth(dim);
		pesce2.setHeight(dim);
		pesce3.setWidth(dim);
		pesce3.setHeight(dim);
		contorno.setWidth(dim);
		contorno.setHeight(dim);
		contorno2.setWidth(dim);
		contorno2.setHeight(dim);
		contorno3.setWidth(dim);
		contorno3.setHeight(dim);
		dolce.setWidth(dim);
		dolce.setHeight(dim);
		dolce2.setWidth(dim);
		dolce2.setHeight(dim);
		dolce3.setWidth(dim);
		dolce3.setHeight(dim);
		frutta.setWidth(dim);
		frutta.setHeight(dim);
		frutta2.setWidth(dim);
		frutta2.setHeight(dim);
		frutta3.setWidth(dim);
		frutta3.setHeight(dim);
		
		layoutRow2.setHeightFull();
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set(style, "1");
		layoutRow2.setAlignItems(Alignment.CENTER);
		layoutRow2.setJustifyContentMode(JustifyContentMode.START);
		h3.setText("SELEZIONA I PIATTI CHE DESIDERI");
		layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h3);
		h3.setWidth("max-content");
		buttonPrimary.setText("ESCI");
		buttonPrimary.setWidth(wid);
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		buttonPrimary2.setText("VAI AL CARRELLO");
		buttonPrimary2.setWidth(wid);
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		//PRIMI
		h1.setText("Primi");
		h1.setWidth("max-content");
		layoutRow3.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set(style, "1");
		layoutColumn2.setHeightFull();
		layoutRow3.setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.setHeight("100%");
		
		
		String font = "font-size";
		String width = "max-content";
		String size = "var(--lumo-font-size-m)";
		String formaggio = "Aggiungi formaggio";
		//primo primo piatto
		textSmall.setText(primi1.get(Piatti.PIATTI.NOME));
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall);
		textSmall.setWidth(width);
		textSmall.getStyle().set(font, size);
		layoutColumn3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set(style, "1");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn3.setAlignItems(Alignment.CENTER);
		buttonSecondary.setText("info");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary);
		buttonSecondary.setWidth(wid);
		checkbox.setLabel(formaggio);
		checkbox.setWidth("100%");
		buttonPrimary3.setText("Aggiungi piatto");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary3);
		buttonPrimary3.setWidth(wid);
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn4.setHeightFull();
		layoutRow3.setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setWidth("100%");
		layoutColumn4.getStyle().set(style, "1");
		
		//secondo primo piatto
		textSmall2.setText(primi2.get(Piatti.PIATTI.NOME));
		layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall2);
		textSmall2.setWidth(width);
		textSmall2.getStyle().set(font, size);
		layoutColumn5.setWidthFull();
		layoutColumn4.setFlexGrow(1.0, layoutColumn5);
		layoutColumn5.setWidth("100%");
		layoutColumn5.getStyle().set(style, "1");
		layoutColumn5.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn5.setAlignItems(Alignment.CENTER);
		buttonSecondary2.setText("info");
		layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary2);
		buttonSecondary2.setWidth(wid);
		checkbox2.setLabel(formaggio);
		checkbox2.setWidth("100%");
		buttonPrimary4.setText("Aggiungi piatto");
		layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary4);
		buttonPrimary4.setWidth(wid);
		buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow4.setHeightFull();
		layoutRow3.setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("100%");
		layoutRow4.getStyle().set(style, "1");
		layoutColumn6.setHeightFull();
		layoutRow4.setFlexGrow(1.0, layoutColumn6);
		layoutColumn6.setWidth("100%");
		layoutColumn6.getStyle().set(style, "1");
		
		//terzo primo
		textSmall3.setText(primi3.get(Piatti.PIATTI.NOME));
		layoutColumn6.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall3);
		textSmall3.setWidth(width);
		textSmall3.getStyle().set(font, size);
		layoutRow5.setWidthFull();
		layoutColumn6.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("100%");
		layoutRow5.getStyle().set(style, "1");
		layoutRow5.setAlignItems(Alignment.CENTER);
		layoutRow5.setJustifyContentMode(JustifyContentMode.CENTER);
		buttonSecondary3.setText("info");
		layoutColumn6.setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary3);
		buttonSecondary3.setWidth(wid);
		checkbox3.setLabel(formaggio);
		checkbox3.setWidth("100%");
		buttonPrimary5.setText("Aggiungi piatto");
		layoutColumn6.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary5);
		buttonPrimary5.setWidth(wid);
		buttonPrimary5.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		//SECONDI
		h12.setText("Secondi");
		h12.setWidth(width);
		layoutRow6.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow6);
		layoutRow6.addClassName(Gap.MEDIUM);
		layoutRow6.setWidth("100%");
		layoutRow6.getStyle().set(style, "1");
		layoutColumn7.setHeightFull();
		layoutRow6.setFlexGrow(1.0, layoutColumn7);
		layoutColumn7.setWidth("100%");
		layoutColumn7.getStyle().set(style, "1");
		textSmall4.setText(secondi1.get(Piatti.PIATTI.NOME));
		layoutColumn7.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall4);
		textSmall4.setWidth(width);
		textSmall4.getStyle().set(font, size);
		layoutColumn8.setWidthFull();
		layoutColumn7.setFlexGrow(1.0, layoutColumn8);
		layoutColumn8.setWidth("100%");
		layoutColumn8.getStyle().set(style, "1");
		layoutColumn8.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn8.setAlignItems(Alignment.CENTER);
		
		buttonSecondary4.setText("info");
		layoutColumn7.setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary4);
		buttonSecondary4.setWidth(wid);
		buttonPrimary6.setText("Aggiungi piatto");
		layoutColumn7.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary6);
		buttonPrimary6.setWidth(wid);
		buttonPrimary6.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn9.setHeightFull();
		layoutRow6.setFlexGrow(1.0, layoutColumn9);
		layoutColumn9.setWidth("100%");
		layoutColumn9.getStyle().set(style, "1");
		textSmall5.setText(secondi2.get(Piatti.PIATTI.NOME));
		layoutColumn9.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall5);
		textSmall5.setWidth(width);
		textSmall5.getStyle().set(font, size);
		layoutColumn10.setWidthFull();
		layoutColumn9.setFlexGrow(1.0, layoutColumn10);
		layoutColumn10.setWidth("100%");
		layoutColumn10.getStyle().set(style, "1");
		layoutColumn10.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn10.setAlignItems(Alignment.CENTER);
		
		buttonSecondary5.setText("info");
		layoutColumn9.setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary5);
		buttonSecondary5.setWidth(wid);
		buttonPrimary7.setText("Aggiungi piatto");
		layoutColumn9.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary7);
		buttonPrimary7.setWidth(wid);
		buttonPrimary7.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow7.setHeightFull();
		layoutRow6.setFlexGrow(1.0, layoutRow7);
		layoutRow7.addClassName(Gap.MEDIUM);
		layoutRow7.setWidth("100%");
		layoutRow7.getStyle().set(style, "1");
		layoutColumn11.setHeightFull();
		layoutRow7.setFlexGrow(1.0, layoutColumn11);
		layoutColumn11.setWidth("100%");
		layoutColumn11.getStyle().set(style, "1");
		textSmall6.setText(secondi3.get(Piatti.PIATTI.NOME));
		layoutColumn11.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall6);
		textSmall6.setWidth(width);
		textSmall6.getStyle().set(font, size);
		layoutColumn12.setWidthFull();
		layoutColumn11.setFlexGrow(1.0, layoutColumn12);
		layoutColumn12.setWidth("100%");
		layoutColumn12.getStyle().set(style, "1");
		layoutColumn12.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn12.setAlignItems(Alignment.CENTER);
		
		buttonSecondary6.setText("info");
		layoutColumn11.setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary6);
		buttonSecondary6.setWidth(wid);
		buttonPrimary8.setText("Aggiungi piatto");
		layoutColumn11.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary8);
		buttonPrimary8.setWidth(wid);
		buttonPrimary8.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		h13.setText("Contorni");
		h13.setWidth(width);
		layoutRow8.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow8);
		layoutRow8.addClassName(Gap.MEDIUM);
		layoutRow8.setWidth("100%");
		layoutRow8.getStyle().set(style, "1");
		layoutColumn13.setHeightFull();
		layoutRow8.setFlexGrow(1.0, layoutColumn13);
		layoutColumn13.setWidth("100%");
		layoutColumn13.getStyle().set(style, "1");
		textSmall7.setText(contorni1.get(Piatti.PIATTI.NOME));
		layoutColumn13.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall7);
		textSmall7.setWidth(width);
		textSmall7.getStyle().set(font, size);
		layoutColumn14.setWidthFull();
		layoutColumn13.setFlexGrow(1.0, layoutColumn14);
		layoutColumn14.setWidth("100%");
		layoutColumn14.getStyle().set(style, "1");
		layoutColumn14.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn14.setAlignItems(Alignment.CENTER);
		
		buttonSecondary7.setText("info");
		buttonSecondary7.setWidth(wid);
		buttonPrimary9.setText("Aggiungi piatto");
		buttonPrimary9.setWidth(wid);
		buttonPrimary9.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn15.setHeightFull();
		layoutRow8.setFlexGrow(1.0, layoutColumn15);
		layoutColumn15.setWidth("100%");
		layoutColumn15.getStyle().set(style, "1");
		textSmall8.setText(contorni2.get(Piatti.PIATTI.NOME));
		layoutColumn15.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall8);
		textSmall8.setWidth(width);
		textSmall8.getStyle().set(font, size);
		layoutColumn16.setWidthFull();
		layoutColumn15.setFlexGrow(1.0, layoutColumn16);
		layoutColumn16.setWidth("100%");
		layoutColumn16.getStyle().set(style, "1");
		layoutColumn16.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn16.setAlignItems(Alignment.CENTER);
		
		buttonSecondary8.setText("info");
		buttonSecondary8.setWidth(wid);
		buttonPrimary10.setText("Aggiungi piatto");
		buttonPrimary10.setWidth(wid);
		buttonPrimary10.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow9.setHeightFull();
		layoutRow8.setFlexGrow(1.0, layoutRow9);
		layoutRow9.addClassName(Gap.MEDIUM);
		layoutRow9.setWidth("100%");
		layoutRow9.getStyle().set(style, "1");
		layoutColumn17.setHeightFull();
		layoutRow9.setFlexGrow(1.0, layoutColumn17);
		layoutColumn17.setWidth("100%");
		layoutColumn17.getStyle().set(style, "1");
		textSmall9.setText(contorni3.get(Piatti.PIATTI.NOME));
		layoutColumn17.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall9);
		textSmall9.setWidth(width);
		textSmall9.getStyle().set(font, size);
		layoutColumn18.setWidthFull();
		layoutColumn17.setFlexGrow(1.0, layoutColumn18);
		layoutColumn18.setWidth("100%");
		layoutColumn18.getStyle().set(style, "1");
		layoutColumn18.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn18.setAlignItems(Alignment.CENTER);
		
		buttonSecondary9.setText("info");
		buttonSecondary9.setWidth(wid);
		buttonPrimary11.setText("Aggiungi piatto");
		buttonPrimary11.setWidth(wid);
		buttonPrimary11.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		h14.setText("Dolci e frutta");
		h14.setWidth(width);
		layoutColumn19.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn19);
		layoutColumn19.setWidth("100%");
		layoutColumn19.getStyle().set(style, "1");
		layoutRow10.setWidthFull();
		layoutColumn19.setFlexGrow(1.0, layoutRow10);
		layoutRow10.addClassName(Gap.MEDIUM);
		layoutRow10.setWidth("100%");
		layoutRow10.getStyle().set(style, "1");
		layoutColumn20.setHeightFull();
		layoutRow10.setFlexGrow(1.0, layoutColumn20);
		layoutColumn20.setWidth("100%");
		layoutColumn20.getStyle().set(style, "1");
		textSmall10.setText(dolciFrutta1.get(Piatti.PIATTI.NOME));
		layoutColumn20.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall10);
		textSmall10.setWidth(width);
		textSmall10.getStyle().set(font, "var(--lumo-font-size-m)");
		layoutColumn21.setWidthFull();
		layoutColumn20.setFlexGrow(1.0, layoutColumn21);
		layoutColumn21.setWidth("100%");
		layoutColumn21.getStyle().set(style, "1");
		layoutColumn21.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn21.setAlignItems(Alignment.CENTER);
		
		buttonSecondary10.setText("info");
		buttonSecondary10.setWidth(wid);
		buttonPrimary12.setText("Aggiungi piatto");
		buttonPrimary12.setWidth(wid);
		buttonPrimary12.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn22.setHeightFull();
		layoutRow10.setFlexGrow(1.0, layoutColumn22);
		layoutColumn22.setWidth("100%");
		layoutColumn22.getStyle().set(style, "1");
		textSmall11.setText(dolciFrutta2.get(Piatti.PIATTI.NOME));
		layoutColumn22.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall11);
		textSmall11.setWidth(width);
		textSmall11.getStyle().set(font, size);
		layoutColumn23.setWidthFull();
		layoutColumn22.setFlexGrow(1.0, layoutColumn23);
		layoutColumn23.setWidth("100%");
		layoutColumn23.getStyle().set(style, "1");
		layoutColumn23.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn23.setAlignItems(Alignment.CENTER);
		
		buttonSecondary11.setText("info");
		buttonSecondary11.setWidth(wid);
		buttonPrimary13.setText("Aggiungi piatto");
		buttonPrimary13.setWidth(wid);
		buttonPrimary13.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow11.setHeightFull();
		layoutRow10.setFlexGrow(1.0, layoutRow11);
		layoutRow11.addClassName(Gap.MEDIUM);
		layoutRow11.setWidth("100%");
		layoutRow11.getStyle().set(style, "1");
		layoutColumn24.setHeightFull();
		layoutRow11.setFlexGrow(1.0, layoutColumn24);
		layoutColumn24.setWidth("100%");
		layoutColumn24.getStyle().set(style, "1");
		textSmall12.setText(dolciFrutta3.get(Piatti.PIATTI.NOME));
		layoutColumn24.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall12);
		textSmall12.setWidth(width);
		textSmall12.getStyle().set(font, size);
		layoutColumn25.setWidthFull();
		layoutColumn24.setFlexGrow(1.0, layoutColumn25);
		layoutColumn25.setWidth("100%");
		layoutColumn25.getStyle().set(style, "1");
		layoutColumn25.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn25.setAlignItems(Alignment.CENTER);
		
		buttonSecondary12.setText("info");
		buttonSecondary12.setWidth(wid);
		buttonPrimary14.setText("Aggiungi piatto");
		buttonPrimary14.setWidth(wid);
		buttonPrimary14.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		getContent().add(layoutRow);
		layoutRow.add(logo);
		layoutRow.add(layoutRow2);
		layoutRow2.add(h3);
		layoutRow.add(buttonPrimary);
		layoutRow.add(buttonPrimary2);
		getContent().add(h1);
		
		getContent().add(layoutRow3);
		layoutRow3.add(layoutColumn2);
		layoutColumn2.add(textSmall);
		
		layoutColumn2.add(layoutColumn3);
		
		
		if(primi1.get(Piatti.PIATTI.IMMAGINE).equals("pasta")) {
			layoutColumn3.add(pasta);
		}else {
			layoutColumn3.add(riso);
		}
		
		layoutColumn2.add(buttonSecondary);
		layoutColumn2.add(checkbox);
		layoutColumn2.add(buttonPrimary3);
		layoutRow3.add(layoutColumn4);
		layoutColumn4.add(textSmall2);
		layoutColumn4.add(layoutColumn5);
		
		if(primi2.get(Piatti.PIATTI.IMMAGINE).equals("pasta")) {
			layoutColumn5.add(pasta2);
		}else {
			layoutColumn5.add(riso2);
		}
		
		layoutColumn4.add(buttonSecondary2);
		layoutColumn4.add(checkbox2);
		layoutColumn4.add(buttonPrimary4);
		layoutRow3.add(layoutRow4);
		layoutRow4.add(layoutColumn6);
		layoutColumn6.add(textSmall3);
		layoutColumn6.add(layoutRow5);
		
		
		if(primi3.get(Piatti.PIATTI.IMMAGINE).equals("pasta")) {
			layoutRow5.add(pasta3);
		}else {
			layoutRow5.add(riso3);
		}

		layoutColumn6.add(buttonSecondary3);
		layoutColumn6.add(checkbox3);
		layoutColumn6.add(buttonPrimary5);
		getContent().add(hr);
		getContent().add(hr2);
		getContent().add(h12);
		getContent().add(layoutRow6);
		layoutRow6.add(layoutColumn7);
		layoutColumn7.add(textSmall4);
		layoutColumn7.add(layoutColumn8);
		
		if(secondi1.get(Piatti.PIATTI.IMMAGINE).equals("carne")) {
			layoutColumn8.add(carne);
		}else {
			layoutColumn8.add(pesce);
		}
		
		layoutColumn7.add(buttonSecondary4);
		layoutColumn7.add(buttonPrimary6);
		layoutRow6.add(layoutColumn9);
		layoutColumn9.add(textSmall5);
		layoutColumn9.add(layoutColumn10);
		
		if(secondi2.get(Piatti.PIATTI.IMMAGINE).equals("carne")) {
			layoutColumn10.add(carne2);
		}else {
			layoutColumn10.add(pesce2);
		}
		
		layoutColumn9.add(buttonSecondary5);
		layoutColumn9.add(buttonPrimary7);
		layoutRow6.add(layoutRow7);
		layoutRow7.add(layoutColumn11);
		layoutColumn11.add(textSmall6);
		layoutColumn11.add(layoutColumn12);
		
		if(secondi3.get(Piatti.PIATTI.IMMAGINE).equals("carne")) {
			layoutColumn12.add(carne3);
		}else {
			layoutColumn12.add(pesce3);
		}
		
		layoutColumn11.add(buttonSecondary6);
		layoutColumn11.add(buttonPrimary8);
		getContent().add(h13);
		getContent().add(layoutRow8);
		layoutRow8.add(layoutColumn13);
		layoutColumn13.add(textSmall7);
		layoutColumn13.add(layoutColumn14);
		
		layoutColumn14.add(contorno);
		
		layoutColumn14.add(buttonSecondary7);
		layoutColumn14.add(buttonPrimary9);
		layoutRow8.add(layoutColumn15);
		layoutColumn15.add(textSmall8);
		layoutColumn15.add(layoutColumn16);
		
		layoutColumn16.add(contorno2);
		
		layoutColumn16.add(buttonSecondary8);
		layoutColumn16.add(buttonPrimary10);
		layoutRow8.add(layoutRow9);
		layoutRow9.add(layoutColumn17);
		layoutColumn17.add(textSmall9);
		layoutColumn17.add(layoutColumn18);
		
		layoutColumn18.add(contorno3);
		
		layoutColumn18.add(buttonSecondary9);
		layoutColumn18.add(buttonPrimary11);
		getContent().add(h14);
		getContent().add(layoutColumn19);
		layoutColumn19.add(layoutRow10);
		layoutRow10.add(layoutColumn20);
		layoutColumn20.add(textSmall10);
		layoutColumn20.add(layoutColumn21);
		
		if(dolciFrutta1.get(Piatti.PIATTI.IMMAGINE).equals("dolce")) {
			layoutColumn21.add(dolce);
		}else {
			layoutColumn21.add(frutta);
		}
		
		layoutColumn21.add(buttonSecondary10);
		layoutColumn21.add(buttonPrimary12);
		layoutRow10.add(layoutColumn22);
		layoutColumn22.add(textSmall11);
		layoutColumn22.add(layoutColumn23);
		
		if(dolciFrutta2.get(Piatti.PIATTI.IMMAGINE).equals("dolce")) {
			layoutColumn23.add(dolce2);
		}else {
			layoutColumn23.add(frutta2);
		}
		
		layoutColumn23.add(buttonSecondary11);
		layoutColumn23.add(buttonPrimary13);
		layoutRow10.add(layoutRow11);
		layoutRow11.add(layoutColumn24);
		layoutColumn24.add(textSmall12);
		layoutColumn24.add(layoutColumn25);
		
		if(dolciFrutta3.get(Piatti.PIATTI.IMMAGINE).equals("dolce")) {
			layoutColumn25.add(dolce3);
		}else {
			layoutColumn25.add(frutta3);
		}
		
		layoutColumn25.add(buttonSecondary12);
		layoutColumn25.add(buttonPrimary14);
		
		
		
		
		
		//LOGICA AGGIUNGI CARRELLO		
		StudenteDocente sd = (StudenteDocente) VaadinSession.getCurrent().getAttribute("SDC");
			
		if (c == null) { 
		    if (sd == null) {
		        c = new Carrello(0000);
		        VaadinSession.getCurrent().setAttribute("CARRELLO", c); 
		        
		    } else {
		        c = new Carrello(sd.getMatricola());
		        VaadinSession.getCurrent().setAttribute("CARRELLO", c); 
		    }
		    
		} else {
		    logger.info("Carrello già esistente nella sessione");
		}
		
		c.addObserver(this);
		
		//LOGICA AGGIUNGI PIATTO
		//PRIMI
		
		buttonPrimary3.addClickListener(event -> {
		if(checkbox.getValue()) {
			    c.aggiungiPiattoConFormaggio(primi1.get(Piatti.PIATTI.NOME));
		}else {
			c.aggiungiPiatto(primi1.get(Piatti.PIATTI.NOME));
		}	
		
		});
		
		buttonPrimary4.addClickListener(event -> {
			if(checkbox2.getValue()) {
				    c.aggiungiPiattoConFormaggio(primi2.get(Piatti.PIATTI.NOME));
			}else {
				c.aggiungiPiatto(primi2.get(Piatti.PIATTI.NOME));
			}
			
			});
		
		buttonPrimary5.addClickListener(event -> {
			if(checkbox3.getValue()) {
				    c.aggiungiPiattoConFormaggio(primi3.get(Piatti.PIATTI.NOME));
			}else {
				c.aggiungiPiatto(primi3.get(Piatti.PIATTI.NOME));
			}	
			
			});
		String info= "infoPiatto";
		buttonSecondary.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, primi1); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary2.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, primi2); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary3.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, primi3); 
			UI.getCurrent().navigate("my-view5");
		});
		
		//SECONDI
		buttonPrimary6.addClickListener(event -> 
			c.aggiungiPiatto(secondi1.get(Piatti.PIATTI.NOME))
         );
		buttonPrimary7.addClickListener(event ->
			c.aggiungiPiatto(secondi2.get(Piatti.PIATTI.NOME))
         );
		buttonPrimary8.addClickListener(event ->
			c.aggiungiPiatto(secondi3.get(Piatti.PIATTI.NOME))
         );
		buttonSecondary4.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, secondi1); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary5.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, secondi2); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary6.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, secondi3); 
			UI.getCurrent().navigate("my-view5");
		});
		//CONTORNI
		buttonPrimary9.addClickListener(event ->
			c.aggiungiPiatto(contorni1.get(Piatti.PIATTI.NOME))
		);
		buttonPrimary10.addClickListener(event ->
			c.aggiungiPiatto(contorni2.get(Piatti.PIATTI.NOME))
		);
		buttonPrimary11.addClickListener(event -> 
			c.aggiungiPiatto(contorni3.get(Piatti.PIATTI.NOME))
		);
		buttonSecondary7.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, contorni1); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary8.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, contorni2); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary9.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, contorni3); 
			UI.getCurrent().navigate("my-view5");
		});
		//DOLCI E FRUTTA
		buttonPrimary12.addClickListener(event ->
			c.aggiungiPiatto(dolciFrutta1.get(Piatti.PIATTI.NOME))
		);
		buttonPrimary13.addClickListener(event ->
			c.aggiungiPiatto(dolciFrutta2.get(Piatti.PIATTI.NOME))
		);
		buttonPrimary14.addClickListener(event ->
			c.aggiungiPiatto(dolciFrutta3.get(Piatti.PIATTI.NOME))
		);
		buttonSecondary10.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, dolciFrutta1); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary11.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, dolciFrutta2); 
			UI.getCurrent().navigate("my-view5");
		});
		buttonSecondary12.addClickListener(event -> {
			VaadinSession.getCurrent().setAttribute(info, dolciFrutta3); 
			UI.getCurrent().navigate("my-view5");
		});
		
		
		//NAVIGAZIONE VIEW
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		int contatore = c.getLista().size();
				buttonPrimary.addClickListener(event -> {for(int i=0; i<contatore; i++) {
					dslContext.update(Piatti.PIATTI).set(Piatti.PIATTI.NUMEROPORZIONI, Piatti.PIATTI.NUMEROPORZIONI.add(1))
					.where(Piatti.PIATTI.NOME.eq(c.getLista().get(i).getKey())).execute();
				}
														UI.getCurrent().navigate("");});
				buttonPrimary2.addClickListener(event -> UI.getCurrent().navigate("my-view6"));
		
	}
	
	public List<Record2<String, String>> primiPiatti(){
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//ritorna i primi piatti
		return dslContext.select(Piatti.PIATTI.NOME, Piatti.PIATTI.IMMAGINE)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NUMEROPORZIONI.greaterThan(0).and(Piatti.PIATTI.TIPOPORTATA.eq(1))).fetch();

	}
	
	public List<Record2<String, String>> secondiPiatti(){
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//ritorna i secondi piatti
		return  dslContext.select(Piatti.PIATTI.NOME, Piatti.PIATTI.IMMAGINE)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NUMEROPORZIONI.greaterThan(0).and(Piatti.PIATTI.TIPOPORTATA.eq(2))).fetch();
	}
	
	public List<Record2<String, String>> contorni(){
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//ritorno la lista di contorni
		return dslContext.select(Piatti.PIATTI.NOME, Piatti.PIATTI.IMMAGINE)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NUMEROPORZIONI.greaterThan(0).and(Piatti.PIATTI.TIPOPORTATA.eq(3))).fetch();
	}
	
	public List<Record2<String, String>> dolciFrutta(){
		Connessione connessione = Connessione.getInstance();
		DSLContext dslContext = connessione.getDslContext();
		//ritorno la lista di dolci e frutta
		return dslContext.select(Piatti.PIATTI.NOME, Piatti.PIATTI.IMMAGINE)
				.from(Piatti.PIATTI).where(Piatti.PIATTI.NUMEROPORZIONI.greaterThan(0).and(Piatti.PIATTI.TIPOPORTATA.eq(4))).fetch();
	}
	
	
	
	
	
	
}
