package gui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import controller.Scontrino;

@PageTitle("Scontrino")
@Route("my-view8")
public class ScontrinoView extends Composite<VerticalLayout> {

	public ScontrinoView() {
		Scontrino sc = new Scontrino();
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		H1 h1 = new H1();
		H6 h6 = new H6();
		HorizontalLayout layoutRow = new HorizontalLayout();
		H4 h4 = new H4();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		H4 h42 = new H4();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		Image image = new Image("images/logo.png", "logo");
		image.setWidth("175px"); // Imposta la larghezza
		image.setHeight("175px"); // Imposta l'altezza
		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		layoutRow2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.setHeight("150px");
		h1.setText("GRAZIE E BUON PRANZO!");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
		String width = "max-content";
		h1.setWidth(width);
		h6.setText("VAI IN CASSA CON IL TUO SCONTRINO");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h6);
		h6.setWidth(width);
		layoutRow.setWidthFull();
		getContent().setFlexGrow(1.0, layoutRow);
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.setHeight("25px");
		layoutRow.setAlignItems(Alignment.START);
		layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
		h4.setText("N°:");
		h4.setWidth(width);
		layoutRow3.setHeightFull();
		layoutRow.setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("0px");
		layoutRow3.getStyle().set("flex-grow", "1");
		h42.setText(""+sc.getNumeroSeriale());
		h42.setWidth(width);
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.setHeight("150px");
		layoutColumn2.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn2.setAlignItems(Alignment.CENTER);
		getContent().add(layoutRow2);
		getContent().add(h1);
		getContent().add(h6);
		getContent().add(layoutRow);
		layoutRow.add(h4);
		layoutRow.add(h42);
		getContent().add(layoutColumn2);
		layoutColumn2.add(image);
		
		
		  UI.getCurrent().getPage().executeJs(
		            "setTimeout(() => window.location.href='', 5000);"
		        );

	}
}
