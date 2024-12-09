package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Portale personale")
@Route("my-view9")
public class PortalepersonaleView extends Composite<VerticalLayout> {

    public PortalepersonaleView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        Icon icon = new Icon();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H3 h3 = new H3();
        Button buttonPrimary = new Button();
        Paragraph textSmall = new Paragraph();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Button buttonPrimary2 = new Button();
        HorizontalLayout layoutRow6 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        MultiSelectListBox textItems = new MultiSelectListBox();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        NumberField numberField = new NumberField();
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
        icon.setIcon("lumo:user");
        icon.setSize("50px");
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
        textSmall.setWidth("480px");
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
        textItems.setWidth("500px");
        setMultiSelectListBoxSampleData(textItems);
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
        buttonPrimary3.setText("Aggiungi quantità");
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
        layoutRow.add(icon);
        layoutRow.add(layoutRow2);
        layoutRow2.add(h3);
        layoutRow.add(buttonPrimary);
        getContent().add(textSmall);
        getContent().add(layoutRow3);
        layoutRow3.add(buttonPrimary2);
        layoutRow3.add(layoutRow6);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(textItems);
        layoutRow4.add(layoutRow5);
        layoutRow5.add(layoutColumn3);
        layoutColumn3.add(numberField);
        layoutColumn3.add(buttonPrimary3);
        layoutColumn3.add(layoutColumn4);
        layoutColumn3.add(buttonPrimary4);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectListBoxSampleData(MultiSelectListBox multiSelectListBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectListBox.setItems(sampleItems);
        multiSelectListBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
        multiSelectListBox.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
