package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import controller.FasciaIsee;
import controller.StudenteDocente;

import java.util.LinkedHashMap;
import java.util.Map;

@PageTitle("Registrazione")
@Route("my-view3")
public class RegistrazioneView extends Composite<VerticalLayout> {

	public RegistrazioneView() {
		// Dichiarazione dei componenti
		H1 h1 = new H1();
		H6 h6 = new H6();
		Hr hr = new Hr();

		IntegerField matricola = new IntegerField();
		TextField textField = new TextField();
		TextField textField2 = new TextField();
		PasswordField passwordField = new PasswordField();
		EmailField emailField = new EmailField();
		ComboBox<FasciaIsee> comboBox = new ComboBox<>();
		Button buttonPrimary = new Button();
		Button buttonPrimary3 = new Button();

		// Layout principali
		VerticalLayout layoutColumn2 = new VerticalLayout();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		VerticalLayout layoutColumn4 = new VerticalLayout();

		// Layout orizzontali
		HorizontalLayout layoutRow = new HorizontalLayout();
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		HorizontalLayout layoutRow5 = new HorizontalLayout();
		HorizontalLayout layoutRow6 = new HorizontalLayout();

		// Impostazioni generali della pagina
		getContent().setWidth("100%");
		String style = "flex-grow"; // Impostazione di stile per la crescita dinamica
		getContent().getStyle().set(style, "1");

		// Intestazioni
		h1.setText("REGISTRAZIONE");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
		h1.setWidth("max-content");

		h6.setText("INSERISCI I TUOI DATI PER REGISTRARTI");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h6);
		h6.setWidth("max-content");

		// Layout e allineamento dei componenti
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set(style, "1");

		// Configurazione layout orizzontali e componenti
		layoutRow.setWidthFull();
		layoutRow.getStyle().set("gap", "75px"); // Riduci lo spazio tra i campi
		layoutRow.setAlignItems(Alignment.CENTER);
		layoutRow.setJustifyContentMode(JustifyContentMode.CENTER); // Avvicina i campi
		textField.setLabel("NOME");
		textField.setWidth("200px");

		layoutRow4.setWidth("auto");
		layoutRow4.getStyle().remove(style); // Rimuovi crescita dinamica
		textField2.setLabel("COGNOME");
		textField2.setWidth("200px");

		layoutRow2.setWidthFull();
		layoutRow2.getStyle().set("gap", "75px");
		layoutRow2.setAlignItems(Alignment.CENTER);
		layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
		matricola.setLabel("MATRICOLA");
		matricola.setWidth("200px");

		layoutRow5.setWidth("auto");
		layoutRow5.getStyle().remove(style); // Rimuovi crescita dinamica
		passwordField.setLabel("PASSWORD");
		passwordField.setWidth("200px");

		// Configurazione di layoutColumn3 (contenitore per ComboBox e EmailField)
		layoutColumn3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set(style, "1");

		layoutRow3.setWidthFull();
		layoutRow3.getStyle().set("gap", "75px"); // Riduci lo spazio tra i campi
		layoutRow3.setAlignItems(Alignment.CENTER);
		layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
		comboBox.setLabel("FASCIA ISEE");
		comboBox.setWidth("200px");
		setComboBoxSampleData(comboBox); // Metodo per impostare i dati della ComboBox

		layoutRow6.setWidth("auto");
		layoutRow6.getStyle().remove(style); // Rimuovi crescita dinamica
		emailField.setLabel("EMAIL UNIVERSITARIA");
		emailField.setWidth("200px");

		// Bottone "Torna indietro"
		buttonPrimary3.setText("TORNA INDIETRO");
		layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary3);
		buttonPrimary3.setWidth("198px");
		buttonPrimary3.getStyle().set(style, "1");
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		// Bottone "Registrati"
		layoutColumn4.setWidthFull();
		layoutColumn3.setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setWidth("100%");
		layoutColumn4.getStyle().set(style, "1");
		layoutColumn4.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn4.setAlignItems(Alignment.CENTER);

		buttonPrimary.setText("REGISTRATI");
		buttonPrimary.setWidth("min-content");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		// Aggiunta dei componenti alla UI
		getContent().add(h1);
		getContent().add(h6);
		getContent().add(hr);
		getContent().add(layoutColumn2);

		// Aggiunta dei componenti al layout verticale (layoutColumn2)
		layoutColumn2.add(layoutRow);
		layoutRow.add(textField);
		layoutRow.add(layoutRow4);
		layoutRow.add(textField2);

		layoutColumn2.add(layoutRow2);
		layoutRow2.add(matricola);
		layoutRow2.add(layoutRow5);
		layoutRow2.add(passwordField);

		layoutColumn2.add(layoutColumn3);
		layoutColumn3.add(layoutRow3);
		layoutRow3.add(comboBox);
		layoutRow3.add(layoutRow6);
		layoutRow3.add(emailField);

		layoutColumn3.add(layoutColumn4);
		layoutColumn4.add(buttonPrimary);
		layoutColumn4.add(buttonPrimary3);

		// Navigazione quando si clicca il bottone "Torna indietro"
		buttonPrimary3.addClickListener(event -> UI.getCurrent().navigate("my-view"));

		// Registrazione dati quando si clicca il bottone "Registrati"
		buttonPrimary.addClickListener(event -> {
		    // Creazione dell'oggetto studente/docente con i dati immessi
		    StudenteDocente sd = new StudenteDocente(
		        matricola.getValue(), 
		        passwordField.getValue(),
		        textField.getValue(), 
		        textField2.getValue(), 
		        emailField.getValue(), 
		        comboBox.getValue(), 
		        0
		    );
		    // Navigazione alla vista successiva
		    UI.getCurrent().navigate("my-view");
		});

	}

	private void setComboBoxSampleData(ComboBox<FasciaIsee> comboBox) {
		// Mappa che associa i valori numerici alle etichette
		Map<FasciaIsee, String> options = new LinkedHashMap<>();
		options.put(FasciaIsee.A, "Fascia A");
		options.put(FasciaIsee.B, "Fascia B");
		options.put(FasciaIsee.C, "Fascia C");
		options.put(FasciaIsee.D, "Fascia D");
		options.put(FasciaIsee.E, "Fascia E");
		options.put(FasciaIsee.F, "Fascia F");
		options.put(FasciaIsee.G, "Fascia G");
		// Imposta i valori numerici come elementi della ComboBox
		comboBox.setItems(options.keySet());

		// Genera l'etichetta per ogni valore numerico
		comboBox.setItemLabelGenerator(options::get);
	}

}
