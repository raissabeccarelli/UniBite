package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("InfoPiatti")
@Route("my-view5")
public class InfoPiattiView extends Composite<VerticalLayout> {

	public InfoPiattiView() {
		VerticalLayout layoutColumn2 = new VerticalLayout();
		H3 h3 = new H3();
		VerticalLayout layoutColumn3 = new VerticalLayout();
		Hr hr = new Hr();
		Icon icon = new Icon();
		H3 h32 = new H3();
		Paragraph textMedium = new Paragraph();
		H3 h33 = new H3();
		Paragraph textMedium2 = new Paragraph();
		H3 h34 = new H3();
		Paragraph textMedium3 = new Paragraph();
		H3 h35 = new H3();
		Paragraph textMedium4 = new Paragraph();
		Button buttonPrimary = new Button();
		buttonPrimary.setText("ESCI");
		buttonPrimary.setWidth("min-content");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set("flex-grow", "1");
		h3.setText("nome piatto");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, h3);
		h3.setWidth("max-content");
		layoutColumn3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set("flex-grow", "1");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn3.setAlignItems(Alignment.CENTER);
		icon.setIcon("lumo:user");
		icon.setSize("300px");
		h32.setText("Descrizione");
		h32.setWidth("max-content");
		textMedium.setText("descrizione piatto");
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.CENTER, textMedium);
		textMedium.setWidth("max-content");
		textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
		h33.setText("Ingredienti");
		h33.setWidth("max-content");
		textMedium2.setText("ingredienti");
		textMedium2.setWidth("max-content");
		textMedium2.getStyle().set("font-size", "var(--lumo-font-size-m)");
		h34.setText("Allergeni");
		h34.setWidth("max-content");
		textMedium3.setText("allergeni");
		textMedium3.setWidth("max-content");
		textMedium3.getStyle().set("font-size", "var(--lumo-font-size-m)");
		h35.setText("Prezzo");
		h35.setWidth("max-content");
		textMedium4.setText("prezzo");
		textMedium4.setWidth("max-content");
		textMedium4.getStyle().set("font-size", "var(--lumo-font-size-m)");
		getContent().add(layoutColumn2);
		layoutColumn2.add(h3);
		layoutColumn2.add(layoutColumn3);
		layoutColumn3.add(hr);
		layoutColumn3.add(icon);
		layoutColumn3.add(h32);
		layoutColumn3.add(textMedium);
		layoutColumn3.add(h33);
		layoutColumn3.add(textMedium2);
		layoutColumn3.add(h34);
		layoutColumn3.add(textMedium3);
		layoutColumn3.add(h35);
		layoutColumn3.add(textMedium4);
		layoutColumn3.add(buttonPrimary);
		buttonPrimary.addClickListener(event -> UI.getCurrent().navigate("my-view4"));
	}
}
