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
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import controller.StudenteDocente;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@PageTitle("Registrazione")
@Route("my-view3")
public class RegistrazioneView extends Composite<VerticalLayout> {

    public RegistrazioneView() {
        H1 h1 = new H1();
        H6 h6 = new H6();
        Hr hr = new Hr();
        
        IntegerField matricola = new IntegerField();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        TextField textField = new TextField();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        TextField textField2 = new TextField();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        PasswordField passwordField = new PasswordField();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        ComboBox<Integer> comboBox = new ComboBox();
        HorizontalLayout layoutRow6 = new HorizontalLayout();
        EmailField emailField = new EmailField();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary3 = new Button();
        
        
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h1.setText("REGISTRAZIONE");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("max-content");
        h6.setText("INSERISCI I TUOI DATI PER REGISTRARTI");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h6);
        h6.setWidth("max-content");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        
        layoutRow.setWidthFull();
        layoutRow.getStyle().set("gap", "75px"); // Riduci lo spazio tra i campi
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER); // Avvicina i campi
        
        textField.setLabel("NOME");
        textField.setWidth("200px");
        layoutRow4.setWidth("auto"); // Riduci larghezza intermedia
        layoutRow4.getStyle().remove("flex-grow"); // Rimuovi crescita dinamica
        textField2.setLabel("COGNOME");
        textField2.setWidth("200px");
        
        layoutRow2.setWidthFull();
        layoutRow2.getStyle().set("gap", "75px"); // Riduci lo spazio tra i campi
        layoutRow2.setAlignItems(Alignment.CENTER);
        layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER); // Avvicina i campi
        
        matricola.setLabel("MATRICOLA");
        matricola.setWidth("200px");
        layoutRow5.setWidth("auto"); // Riduci larghezza intermedia
        layoutRow5.getStyle().remove("flex-grow"); // Rimuovi crescita dinamica
        passwordField.setLabel("PASSWORD");
        passwordField.setWidth("200px");
        
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        
        layoutRow3.setWidthFull();
        layoutRow3.getStyle().set("gap", "75px"); // Riduci lo spazio tra i campi
        layoutRow3.setAlignItems(Alignment.CENTER);
        layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER); // Avvicina i campi
        
        comboBox.setLabel("FASCIA ISEE");
        comboBox.setWidth("200px");
        setComboBoxSampleData(comboBox);
        layoutRow6.setWidth("auto"); // Riduci larghezza intermedia
        layoutRow6.getStyle().remove("flex-grow"); // Rimuovi crescita dinamica
        emailField.setLabel("EMAIL UNIVERSITARIA");
        emailField.setWidth("200px");
        
        buttonPrimary3.setText("TORNA INDIETRO");
        layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary3);
        buttonPrimary3.setWidth("198px");
        buttonPrimary3.getStyle().set("flex-grow", "1");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        
        layoutColumn4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn4.setAlignItems(Alignment.CENTER);
        buttonPrimary.setText("REGISTRATI");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);        
        getContent().add(h1);
        getContent().add(h6);
        getContent().add(hr);
        getContent().add(layoutColumn2);
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
        buttonPrimary3.addClickListener(event -> UI.getCurrent().navigate("my-view"));
        
        buttonPrimary.addClickListener(event -> {
        StudenteDocente sd = new StudenteDocente (matricola.getValue(), passwordField.getValue(), textField.getValue(), 
        		textField2.getValue(), emailField.getValue(), comboBox.getValue(), 0);
       	UI.getCurrent().navigate("my-view");
       	});
    }

    private void setComboBoxSampleData(ComboBox<Integer> comboBox) {
        // Mappa che associa i valori numerici alle etichette
        Map<Integer, String> options = new LinkedHashMap<>();
        options.put(1, "Fascia A");
        options.put(2, "Fascia B");
        options.put(3, "Fascia C");
        options.put(4, "Fascia D");
        options.put(5, "Fascia E");
        options.put(6, "Fascia F");
        options.put(7, "Fascia G");
        // Imposta i valori numerici come elementi della ComboBox
        comboBox.setItems(options.keySet());

        // Genera l'etichetta per ogni valore numerico
        comboBox.setItemLabelGenerator(value -> options.get(value));
    }

    
}
