package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Aggiungi ricetta")
@Route("my-view10")
public class AggiungiricettaView extends Composite<VerticalLayout> {

	public AggiungiricettaView() {
	    // Layout principale che contiene il form
	    VerticalLayout layoutColumn2 = new VerticalLayout();
	    layoutColumn2.setWidthFull();  // Assicura che il layout prenda tutta la larghezza disponibile
	    layoutColumn2.setHeightFull(); // Assicura che il layout prenda tutta l'altezza disponibile
	    layoutColumn2.setAlignItems(Alignment.CENTER); // Centra orizzontalmente
	    layoutColumn2.setJustifyContentMode(JustifyContentMode.CENTER); // Centra verticalmente

	    // Titolo
	    H3 h3 = new H3("AGGIUNGI UNA NUOVA RICETTA");
	    h3.setWidth("max-content");
	    
	    // Separator (linea orizzontale)
	    Hr hr = new Hr();

	    // Sezione del nome ricetta e descrizione
	    HorizontalLayout layoutRow = new HorizontalLayout();
	    TextField textField = new TextField("Nome ricetta");
	    textField.setWidth("450px");
	    TextField textField2 = new TextField("Descrizione");
	    textField2.setWidth("450px");
	    layoutRow.add(textField, textField2);
	    layoutRow.setAlignItems(Alignment.CENTER);  // Centra gli input orizzontalmente

	    // Sezione degli ingredienti e allergeni
	    HorizontalLayout layoutRow2 = new HorizontalLayout();
	    TextField textField3 = new TextField("Ingredienti");
	    textField3.setWidth("450px");
	    TextField textField4 = new TextField("Allergeni");
	    textField4.setWidth("450px");
	    layoutRow2.add(textField3, textField4);
	    layoutRow2.setAlignItems(Alignment.CENTER);  // Centra gli input orizzontalmente

	    // Sezione dei selettori
	    HorizontalLayout layoutRow3 = new HorizontalLayout();
	    Select<String> select = new Select<>();
	    select.setLabel("Tipo di portata");
	    select.setWidth("450px");
	    Select<String> select2 = new Select<>();
	    select2.setLabel("Scegli categoria");
	    select2.setWidth("450px");
	    layoutRow3.add(select, select2);
	    layoutRow3.setAlignItems(Alignment.CENTER);  // Centra i selettori orizzontalmente

	    // Sezione dei bottoni
	    HorizontalLayout layoutRow4 = new HorizontalLayout();
	    Button buttonPrimary = new Button("ANNULLA");
	    buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	    Button buttonPrimary2 = new Button("AGGIUNGI");
	    buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	    layoutRow4.add(buttonPrimary, buttonPrimary2);
	    layoutRow4.setAlignItems(Alignment.CENTER);  // Centra i bottoni orizzontalmente

	    // Aggiungi tutto al layout principale
	    layoutColumn2.add(h3, hr, layoutRow, layoutRow2, layoutRow3, layoutRow4);

	    // Aggiungi il layout principale alla vista
	    getContent().add(layoutColumn2);
	}


    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
