package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.*;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import controller.Personale;
import controller.Piatto;
import controller.StudenteDocente;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record2;

@PageTitle("Portale personale")
@Route("my-view9")
public class PortalepersonaleView extends Composite<VerticalLayout> {

	public PortalepersonaleView() {
		HorizontalLayout layoutRow = new HorizontalLayout();
		Image image = new Image("images/logo.png", "logo");
		image.setWidth("100px"); // Imposta la larghezza
		image.setHeight("100px"); // Imposta l'altezza
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		H3 h3 = new H3();
		Button buttonPrimary = new Button();
		Paragraph textSmall = new Paragraph();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		Button buttonPrimary2 = new Button();
		HorizontalLayout layoutRow6 = new HorizontalLayout();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		HorizontalLayout layoutRow4 = new HorizontalLayout();

		List<Record2<String, Integer>> piatti = Piatto.cercaPiatti();
		Grid<Record2<String, Integer>> grid = new Grid<>();

		HorizontalLayout layoutRow5 = new HorizontalLayout();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		IntegerField numberField = new IntegerField();
		Button buttonPrimary3 = new Button();
		VerticalLayout layoutColumn4 = new VerticalLayout();
		Button buttonPrimary4 = new Button();
		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		layoutRow.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow);
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.setHeight("min-content");
		layoutRow.setAlignItems(Alignment.CENTER);
		layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);

		layoutRow2.setHeightFull();
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.setHeight("min-content");
		h3.setText("MODIFICA IL MENU' DEL GIORNO");
		h3.setWidth("max-content");
		buttonPrimary.setText("LOGOUT");
		buttonPrimary.setWidth("min-content");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		textSmall.setText(
				"Per aggiungere un piatto al menù, selezionalo e clicca \"Aggiungi quantità\". Per eliminarlo dal menù, selezionalo e clicca \"Elimina piatto\". Per aggiungere una ricetta seleziona \"Aggiungi ricetta\".");
		textSmall.setWidth("5000px");
		textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
		layoutRow3.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.setHeight("min-content");
		layoutRow3.setAlignItems(Alignment.START);
		layoutRow3.setJustifyContentMode(JustifyContentMode.START);
		buttonPrimary2.setText("Aggiungi ricetta");
		buttonPrimary2.setWidth("min-content");
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow6.setHeightFull();
		layoutRow3.setFlexGrow(1.0, layoutRow6);
		layoutRow6.addClassName(Gap.MEDIUM);
		layoutRow6.getStyle().set("flex-grow", "1");
		layoutRow6.getStyle().set("flex-grow", "1");
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set("flex-grow", "1");
		layoutRow4.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("100%");
		layoutRow4.getStyle().set("flex-grow", "1");

		grid.setWidth("5000px");
		// Imposta le colonne della Grid
		grid.addColumn(record -> record.value1()) // NOME
				.setHeader("Nome Piatto").setKey("nome");

		grid.addColumn(record -> record.value2()) // NUMEROPORZIONI
				.setHeader("Numero Porzioni").setKey("numeroPorzioni");

		// Imposta i dati da visualizzare nella Grid
		grid.setItems(piatti);

		layoutRow5.setHeightFull();
		layoutRow4.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("100%");
		layoutRow5.getStyle().set("flex-grow", "1");
		layoutColumn3.setHeightFull();
		layoutRow5.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set("flex-grow", "1");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn3.setAlignItems(Alignment.CENTER);
		numberField.setLabel("Inserisci porzioni");
		numberField.setWidth("179px");
		buttonPrimary3.setText("Imposta il numero di porzioni");
		buttonPrimary3.setWidth("min-content");
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn4.setWidthFull();
		layoutColumn3.setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setWidth("100%");
		layoutColumn4.setHeight("20px");
		buttonPrimary4.setText("Elimina piatto ❌");
		buttonPrimary4.setWidth("179px");
		buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		getContent().add(layoutRow);
		layoutRow.add(image);
		layoutRow.add(layoutRow2);
		layoutRow2.add(h3);
		layoutRow.add(buttonPrimary);
		getContent().add(textSmall);
		getContent().add(layoutRow3);
		layoutRow3.add(buttonPrimary2);
		layoutRow3.add(layoutRow6);
		getContent().add(layoutColumn2);
		layoutColumn2.add(layoutRow4);
		layoutRow4.add(grid);
		layoutRow4.add(layoutRow5);
		layoutRow5.add(layoutColumn3);
		layoutColumn3.add(numberField);
		layoutColumn3.add(buttonPrimary3);
		layoutColumn3.add(layoutColumn4);
		layoutColumn3.add(buttonPrimary4);

		buttonPrimary2.addClickListener(event -> UI.getCurrent().navigate("my-view10"));
		buttonPrimary.addClickListener(event -> UI.getCurrent().navigate(""));
		Personale p = new Personale();
		buttonPrimary3.addClickListener(event -> {
			p.aggiungiPorzioni(grid.getSelectedItems(), numberField.getValue());
			UI.getCurrent().refreshCurrentRoute(isAttached());
		});
		buttonPrimary4.addClickListener(event -> {
			
			p.eliminaPiatto(grid.getSelectedItems());
			UI.getCurrent().refreshCurrentRoute(isAttached());
		});
	}

}
