package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import controller.Personale;

@PageTitle("Login P")
@Route("my-view2")
//Login per i membri del personale (Username e password preimpostati)
public class LoginPView extends Composite<VerticalLayout> {

	public LoginPView() {
		//Impostazioni per il layout della view ed instanziazione 
		//delle componenti principali
		
		H1 h1 = new H1();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		H6 h6 = new H6();
		Hr hr = new Hr();
		VerticalLayout layoutColumn = new VerticalLayout();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		TextField textField = new TextField();
		VerticalLayout layoutColumn4 = new VerticalLayout();
		PasswordField passwordField = new PasswordField();
		VerticalLayout layoutColumn5 = new VerticalLayout();
		Button buttonPrimary = new Button();

		Button buttonPrimary3 = new Button();

		getContent().setHeightFull();
		getContent().setWidthFull();
		h1.setText("LOGIN"); //Titolo della view
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
		h1.setWidth("max-content");
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		String style = "flex-grow";
		layoutColumn2.getStyle().set(style, "0.02");
		h6.setText("INSERISCI LE CREDENZIALI"); //Istruzioni per il login
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, h6);
		h6.setWidth("max-content");
		layoutColumn3.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set(style, "0.02");
		textField.setLabel("USERNAME"); //Spazio per inserire l'username
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, textField);
		textField.setWidth("200px");
		layoutColumn4.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setWidth("100%");
		layoutColumn4.getStyle().set(style, "0.02");
		passwordField.setLabel("PASSWORD"); //Spazio per inserire la password
		layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, passwordField);
		passwordField.setWidth("200px");
		layoutColumn5.setWidthFull();
		layoutColumn4.setFlexGrow(1.0, layoutColumn5);
		layoutColumn5.setWidth("100%");
		layoutColumn5.getStyle().set(style, "0.02");
		//Bottone che avvia il contollo di username e password
		//Se le credenziali inserite sono corrette, porta a PortalepersonaleView
		//altrimenti rimane in questa view
		buttonPrimary.setText("ACCEDI"); 		                                 
		buttonPrimary.addClickShortcut(com.vaadin.flow.component.Key.ENTER);
		layoutColumn5.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
		buttonPrimary.setWidth("192px");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn);
		layoutColumn.setWidth("100%");
		layoutColumn.getStyle().set(style, "0.02");

		//Permette di tornare a UNIBiteView
		buttonPrimary3.setText("TORNA INDIETRO");
		layoutColumn5.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary3);
		buttonPrimary3.setWidth("198px");
		buttonPrimary3.getStyle().set(style, "1");
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		getContent().add(h1);
		getContent().add(layoutColumn2);
		layoutColumn2.add(h6);
		getContent().add(hr);
		getContent().add(layoutColumn);
		getContent().add(layoutColumn3);
		layoutColumn3.add(textField);
		getContent().add(layoutColumn4);
		layoutColumn4.add(passwordField);
		layoutColumn4.add(layoutColumn5);
		layoutColumn5.add(buttonPrimary);
		layoutColumn5.add(buttonPrimary3);
		buttonPrimary3.addClickListener(event -> UI.getCurrent().navigate(""));
		//Porta a UNIBiteView

		Personale p = new Personale();
		buttonPrimary.addClickListener(event -> {
			if (p.login(textField.getValue(), passwordField.getValue())) {
				UI.getCurrent().navigate("my-view9"); //Se le credenziali sono corrette porta a PortalepersonaleView
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
