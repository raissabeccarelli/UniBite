package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import controller.Personale;
import controller.TipoPortata;
import java.util.LinkedHashMap;
import java.util.Map;

@PageTitle("Aggiungi ricetta")
@Route("my-view10")
public class AggiungiricettaView extends Composite<VerticalLayout> {

	public AggiungiricettaView() {
		// Layout principale che contiene il form
		VerticalLayout layoutColumn2 = new VerticalLayout();
		ComboBox<TipoPortata> comboBox = new ComboBox<>();
		ComboBox<String> comboBox2 = new ComboBox<>();
		layoutColumn2.setWidthFull(); // Assicura che il layout prenda tutta la larghezza disponibile
		layoutColumn2.setHeightFull(); // Assicura che il layout prenda tutta l'altezza disponibile
		layoutColumn2.setAlignItems(Alignment.CENTER); // Centra orizzontalmente
		layoutColumn2.setJustifyContentMode(JustifyContentMode.CENTER); // Centra verticalmente

		// Titolo
		H3 h3 = new H3("AGGIUNGI UNA NUOVA RICETTA");
		h3.setWidth("max-content");

		// Separator (linea orizzontale)
		Hr hr = new Hr();

		VerticalLayout layoutColumn3 = new VerticalLayout();
		layoutColumn3.setWidthFull(); // Assicura che il layout prenda tutta la larghezza disponibile
		layoutColumn3.setHeight("80px"); // Assicura che il layout prenda tutta l'altezza disponibile
		layoutColumn3.setAlignItems(Alignment.CENTER); // Centra orizzontalmente
		layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER); // Centra verticalmente

		// Sezione del nome ricetta e descrizione
		HorizontalLayout layoutRow = new HorizontalLayout();
		TextField textField = new TextField("Nome ricetta");
		String width = "450px";
		textField.setWidth(width);
		TextField textField2 = new TextField("Descrizione");
		textField2.setWidth(width);
		layoutRow.add(textField, textField2);
		layoutRow.setAlignItems(Alignment.CENTER); // Centra gli input orizzontalmente

		// Sezione degli ingredienti e allergeni
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		TextField textField3 = new TextField("Ingredienti");
		textField3.setWidth(width);
		TextField textField4 = new TextField("Allergeni");
		textField4.setWidth(width);
		layoutRow2.add(textField3, textField4);
		layoutRow2.setAlignItems(Alignment.CENTER); // Centra gli input orizzontalmente

		// Sezione dei selettori
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		comboBox.setLabel("Tipo di portata");
		comboBox.setWidth(width);
		setComboBoxSampleData(comboBox);
		comboBox2.setLabel("Categoria");
		comboBox2.setWidth(width);
		setComboBoxSampleData2(comboBox2);
		layoutRow3.add(comboBox, comboBox2);
		layoutRow3.setAlignItems(Alignment.CENTER); // Centra i selettori orizzontalmente

		// Sezione dei bottoni
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		Button buttonPrimary = new Button("ANNULLA");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		Button buttonPrimary2 = new Button("AGGIUNGI");
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow4.add(buttonPrimary, buttonPrimary2);
		layoutRow4.setAlignItems(Alignment.CENTER); // Centra i bottoni orizzontalmente

		// Aggiungi tutto al layout principale
		layoutColumn2.add(h3, hr, layoutColumn3, layoutRow, layoutRow2, layoutRow3, layoutRow4);

		// Aggiungi il layout principale alla vista
		getContent().add(layoutColumn2);

		buttonPrimary.addClickListener(event -> UI.getCurrent().navigate("my-view9"));
		buttonPrimary2.addClickListener(event -> {
			Personale p = new Personale();
			p.creaNuovoPiatto(textField.getValue(), textField2.getValue(), textField3.getValue(), textField4.getValue(),
					comboBox.getValue(), comboBox2.getValue());
			UI.getCurrent().navigate("my-view9");
		});

	}

	private void setComboBoxSampleData(ComboBox<TipoPortata> comboBox) {
		// Mappa che associa i valori numerici alle etichette
		Map<TipoPortata, String> options = new LinkedHashMap<>();
		options.put(TipoPortata.PRIMO, "Primo");
		options.put(TipoPortata.SECONDO, "Secondo");
		options.put(TipoPortata.CONTORNO, "Contorno");
		options.put(TipoPortata.DOLCEFRUTTA, "Dolce o Frutta");
		// Imposta i valori numerici come elementi della ComboBox
		comboBox.setItems(options.keySet());

		// Genera l'etichetta per ogni valore numerico
		comboBox.setItemLabelGenerator(options::get);
	}

	private void setComboBoxSampleData2(ComboBox<String> comboBox) {
		// Mappa che associa i valori numerici alle etichette
		Map<String, String> options = new LinkedHashMap<>();
		options.put("pasta", "Pasta");
		options.put("riso", "Riso");
		options.put("carne", "Carne");
		options.put("pesce", "Pesce");
		options.put("contorno", "Contorno");
		options.put("frutta", "Frutta");
		options.put("dolce", "Dolce");
		// Imposta i valori numerici come elementi della ComboBox
		comboBox.setItems(options.keySet());

		// Genera l'etichetta per ogni valore numerico
		comboBox.setItemLabelGenerator(options::get);
	}

}
