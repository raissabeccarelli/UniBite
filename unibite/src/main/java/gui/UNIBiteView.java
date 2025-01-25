package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
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
import controller.Esterno;

@PageTitle("UNIBite")
@Route("")
public class UNIBiteView extends Composite<VerticalLayout> {

	public UNIBiteView() {
		// Creazione dei layout principali
	    HorizontalLayout headerLayout = new HorizontalLayout();
	    HorizontalLayout buttonRowLayout = new HorizontalLayout();
	    VerticalLayout mainLayout = new VerticalLayout();

	    // Configurazione del logo
	    Image logo = new Image("images/logo.png", "logo");
	    logo.setWidth("150px");
	    logo.setHeight("150px");

	    // Intestazioni
	    H1 title = new H1("BENVENUTO!!");
	    title.setWidth("max-content");

	    H6 subtitle = new H6("Accedi come:");
	    subtitle.setWidth("max-content");

	    // Linea di separazione
	    Hr separator = new Hr();

	    // Creazione dei bottoni
	    Button bottoneStudente = new Button("STUDENTE/DOCENTE");
	    bottoneStudente.setWidth("min-content");
	    bottoneStudente.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

	    Button bottoneEsterno = new Button("ESTERNO");
	    bottoneEsterno.setWidth("198px");
	    bottoneEsterno.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

	    Button bottonePersonale = new Button("PERSONALE");
	    bottonePersonale.setWidth("198px");
	    bottonePersonale.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

	    // Configurazione layout principale
	    mainLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
	    mainLayout.setSpacing(true);
	    mainLayout.setSizeFull();

	    // Aggiunta degli elementi al layout principale
	    mainLayout.add(logo, title, subtitle, separator, bottoneStudente, bottoneEsterno, bottonePersonale);

	    // Configurazione del layout superiore (header)
	    headerLayout.setWidthFull();
	    headerLayout.setAlignItems(FlexComponent.Alignment.CENTER);
	    headerLayout.add(mainLayout);

	    // Aggiunta del layout principale al contenuto della vista
	    getContent().setWidth("100%");
	    getContent().add(headerLayout);

	    // Event listener per i bottoni
	    // Navigazione alla vista login StudenteDocente
	    bottoneStudente.addClickListener(event -> UI.getCurrent().navigate("my-view"));

	    bottoneEsterno.addClickListener(event -> {
	        // Reset delle sessioni
	        VaadinSession.getCurrent().setAttribute("CARRELLO", null);
	        VaadinSession.getCurrent().setAttribute("E", null);
	        VaadinSession.getCurrent().setAttribute("SDC", null);

	        // Creazione di un oggetto "Esterno" e salvataggio nella sessione
	        Esterno externalUser = new Esterno(0000);
	        VaadinSession.getCurrent().setAttribute("E", externalUser);

	        // Navigazione alla vista portale ordinazione
	        UI.getCurrent().navigate("my-view4");
	    });

	    bottonePersonale.addClickListener(event -> UI.getCurrent().navigate("my-view2"));
	}
}
