package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import controller.StudenteDocente;

@PageTitle("Login SD")
@Route("my-view")
//Login per gli utenti di tipo StudenteDocente
public class LoginSDView extends Composite<VerticalLayout> {

	public LoginSDView() {
		//Impostazioni per il layout della view ed instanziazione 
		//delle componenti principali
		
		H1 h1 = new H1();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		H6 h6 = new H6();
		Hr hr = new Hr();

		HorizontalLayout layoutRow = new HorizontalLayout();
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		IntegerField matricola = new IntegerField();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		PasswordField passwordField = new PasswordField();
		VerticalLayout layoutColumn4 = new VerticalLayout();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		VerticalLayout layoutColumn5 = new VerticalLayout();
		HorizontalLayout layoutRow5 = new HorizontalLayout();
		Button buttonPrimary = new Button();
		VerticalLayout layoutColumn6 = new VerticalLayout();
		HorizontalLayout layoutRow6 = new HorizontalLayout();
		H4 h4 = new H4();
		Button buttonPrimary2 = new Button();
		Button buttonPrimary3 = new Button();
		
		getContent().setWidth("100%");
		String style = "flex-grow";
		getContent().getStyle().set(style, "1");
		h1.setText("LOGIN"); //Titolo della view
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
		String width = "max-content";
		h1.setWidth(width);
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set(style, "1");
		h6.setText("INSERISCI I TUOI DATI:"); //Istruzioni per il login
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, h6);
		h6.setWidth(width);
		layoutRow.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow);
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.getStyle().set(style, "1");
		layoutRow2.setHeightFull();
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set(style, "1");
		layoutRow2.setAlignItems(Alignment.CENTER);
		layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
		matricola.setLabel("MATRICOLA"); //Spazio per inserire la matricola
		layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, matricola);
		matricola.setWidth("200px");
		layoutColumn3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set(style, "1");
		layoutRow3.setWidthFull();
		layoutColumn3.setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set(style, "1");
		layoutRow3.setAlignItems(Alignment.CENTER);
		layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
		passwordField.setLabel("PASSWORD"); //Spazio per inserire la password
		passwordField.setWidth("200px");
		layoutColumn4.setWidthFull();
		layoutColumn3.setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setWidth("100%");
		layoutColumn4.getStyle().set(style, "1");
		layoutRow4.setWidthFull();
		layoutColumn4.setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("100%");
		layoutRow4.getStyle().set(style, "1");
		layoutColumn5.setHeightFull();
		layoutRow4.setFlexGrow(1.0, layoutColumn5);
		layoutColumn5.setWidth("100%");
		layoutColumn5.getStyle().set(style, "1");
		layoutRow5.setWidthFull();
		layoutColumn5.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("100%");
		layoutRow5.getStyle().set(style, "1");
		layoutRow5.setAlignItems(Alignment.CENTER);
		layoutRow5.setJustifyContentMode(JustifyContentMode.CENTER);
		//Bottone che avvia il contollo di matricola e password
		//Se le credenziali inserite sono corrette, porta a PortaleordinazioneView
		//altrimenti rimane in questa view
		buttonPrimary.setText("ACCEDI");
		buttonPrimary.addClickShortcut(com.vaadin.flow.component.Key.ENTER);
		layoutRow5.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
		buttonPrimary.setWidth("192px");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn6.setWidthFull();
		layoutColumn5.setFlexGrow(1.0, layoutColumn6);
		layoutColumn6.setWidth("100%");
		layoutColumn6.getStyle().set(style, "1");
		layoutColumn6.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn6.setAlignItems(Alignment.CENTER);
		layoutRow6.setWidthFull();
		layoutColumn6.setFlexGrow(1.0, layoutRow6);
		layoutRow6.addClassName(Gap.MEDIUM);
		layoutRow6.setWidth("100%");
		layoutRow6.getStyle().set(style, "1");
		layoutRow6.setAlignItems(Alignment.CENTER);
		layoutRow6.setJustifyContentMode(JustifyContentMode.CENTER);
		//Testo dedicato ad utenti di tipo StudenteDocete non ancora registarti
		h4.setText("Non sei ancora registrato?");
		h4.setWidth(width);
		buttonPrimary2.setText("REGISTRATI"); //Bottone che porta a RegistrazioneView
		buttonPrimary2.setWidth("min-content");
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		//Bottone che permette di tornare a UNIBiteView
		buttonPrimary3.setText("TORNA INDIETRO");
		layoutColumn6.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary3);
		buttonPrimary3.setWidth("198px");
		buttonPrimary3.getStyle().set(style, "1");
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		getContent().add(h1);
		getContent().add(layoutColumn2);
		layoutColumn2.add(h6);
		layoutColumn2.add(hr);
		layoutColumn2.add(layoutRow);
		layoutRow.add(layoutRow2);
		layoutRow2.add(matricola);
		layoutColumn2.add(layoutColumn3);
		layoutColumn3.add(layoutRow3);
		layoutRow3.add(passwordField);
		layoutColumn3.add(layoutColumn4);
		layoutColumn4.add(layoutRow4);
		layoutRow4.add(layoutColumn5);
		layoutColumn5.add(layoutRow5);
		layoutRow5.add(buttonPrimary);
		layoutColumn5.add(layoutColumn6);
		layoutColumn6.add(layoutRow6);
		layoutRow6.add(h4);
		layoutRow6.add(buttonPrimary2);
		layoutColumn6.add(buttonPrimary3);
		
		//Porta a RegistrazioneView
		buttonPrimary2.addClickListener(event -> UI.getCurrent().navigate("my-view3"));
		
		//Porta a UNIBiteView
		buttonPrimary3.addClickListener(event -> UI.getCurrent().navigate(""));

		StudenteDocente sd = new StudenteDocente();
		buttonPrimary.addClickListener(event -> {
			if (sd.login(matricola.getValue(), passwordField.getValue())) {
				
		        VaadinSession.getCurrent().setAttribute("CARRELLO", null);
		        StudenteDocente st = new StudenteDocente(matricola.getValue());
				VaadinSession.getCurrent().setAttribute("SDC", st);
				UI.getCurrent().navigate("my-view4"); //Se le credenziali sono corrette porta a PortaleordinazioneView
			}else {
				 Notification notification = new Notification(
		                    "Credenziali errate. Riprova.", 3000); //Notifica di credenziali errate
		                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
		                notification.setPosition(Position.TOP_CENTER);
		                notification.open();
			}
		});
		
	}

}
