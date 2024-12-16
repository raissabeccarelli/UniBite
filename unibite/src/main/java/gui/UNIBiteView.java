package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("UNIBite")
@Route("")
public class UNIBiteView extends Composite<VerticalLayout> {

	public UNIBiteView() {
		HorizontalLayout layoutRow = new HorizontalLayout();
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		HorizontalLayout layoutRow5 = new HorizontalLayout();
		H1 h1 = new H1();
		H6 h6 = new H6();
		Hr hr = new Hr();
		Button buttonPrimary = new Button();
		Button buttonPrimary2 = new Button();
		Button buttonPrimary3 = new Button();
		Image image = new Image("images/logo.png", "logo");
		image.setWidth("150px"); // Imposta la larghezza
		image.setHeight("150px"); // Imposta l'altezza
		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.getStyle().set("flex-grow", "1");
		layoutRow2.setHeightFull();
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set("flex-grow", "1");
		layoutRow3.setHeightFull();
		layoutRow2.setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set("flex-grow", "1");
		layoutRow3.setAlignItems(Alignment.CENTER);
		layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn2.setHeightFull();
		layoutRow3.setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set("flex-grow", "1");
		layoutColumn3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.setHeight("426px");
		layoutRow4.setWidthFull();
		layoutColumn3.setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("100%");
		layoutRow4.getStyle().set("flex-grow", "1");
		layoutRow4.setAlignItems(Alignment.CENTER);
		layoutRow4.setJustifyContentMode(JustifyContentMode.CENTER);

		layoutRow5.setHeightFull();
		layoutRow4.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("0px");
		layoutRow5.setHeight("0px");
		h1.setText("BENVENUTO!!");
		h1.setWidth("max-content");
		h6.setText("Accedi come:");
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, h6);
		h6.setWidth("max-content");
		buttonPrimary.setText("STUDENTE/DOCENTE");
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
		buttonPrimary.setWidth("min-content");
		buttonPrimary.getStyle().set("flex-grow", "1");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		buttonPrimary2.setText("ESTERNO");
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary2);
		buttonPrimary2.setWidth("198px");
		buttonPrimary2.getStyle().set("flex-grow", "1");
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		buttonPrimary3.setText("PERSONALE");
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary3);
		buttonPrimary3.setWidth("198px");
		buttonPrimary3.getStyle().set("flex-grow", "1");
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		getContent().add(layoutRow);
		layoutRow.add(layoutRow2);
		layoutRow2.add(layoutRow3);
		layoutRow3.add(layoutColumn2);
		layoutColumn2.add(layoutColumn3);
		layoutColumn3.add(layoutRow4);
		layoutRow4.add(image);
		layoutRow4.add(h1);
		layoutColumn3.add(h6);
		layoutColumn3.add(hr);
		layoutColumn3.add(buttonPrimary);
		layoutColumn3.add(buttonPrimary2);
		layoutColumn3.add(buttonPrimary3);
		buttonPrimary.addClickListener(event -> UI.getCurrent().navigate("my-view"));
		buttonPrimary2.addClickListener(event -> UI.getCurrent().navigate("my-view4"));
		buttonPrimary3.addClickListener(event -> UI.getCurrent().navigate("my-view2"));
	}
}
