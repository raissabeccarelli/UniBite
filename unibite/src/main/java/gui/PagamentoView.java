package gui;

import org.jooq.DSLContext;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import controller.Carrello;
import controller.StudenteDocente;
import generated.tables.Accountutenti;
import model.Connessione;

@PageTitle("Pagamento")
@Route("my-view7")
public class PagamentoView extends Composite<VerticalLayout> {

	public PagamentoView() {
		StudenteDocente sd = (StudenteDocente) VaadinSession.getCurrent().getAttribute("SDC");	
		Carrello c = (Carrello) VaadinSession.getCurrent().getAttribute("CARRELLO");	
		H1 h1 = new H1();
		Hr hr = new Hr();
		Paragraph textSmall = new Paragraph();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		HorizontalLayout layoutRow = new HorizontalLayout();
		HorizontalLayout layoutRow2 = new HorizontalLayout();
		HorizontalLayout layoutRow4 = new HorizontalLayout();
		H4 h4 = new H4();
		H4 h6 = new H4();
		HorizontalLayout layoutRow3 = new HorizontalLayout();
		Button buttonPrimary = new Button();
		HorizontalLayout layoutRow5 = new HorizontalLayout();
		Button buttonPrimary2 = new Button();
		getContent().setWidth("100%");
		String style = "flex-grow";
		getContent().getStyle().set(style, "1");
		h1.setText("PAGAMENTO");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
		String width = "max-content";
		h1.setWidth(width);
		textSmall.setText("Scegli se pagare in cassa oppure se addebitare il pranzo sul tuo conto virtuale");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textSmall);
		textSmall.setWidth(width);
		textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set(style, "1");
		layoutRow.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow);
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.getStyle().set(style, "1");
		layoutRow2.setHeightFull();
		layoutRow.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set(style, "1");
		layoutRow2.setAlignItems(Alignment.CENTER);
		layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutRow4.setHeightFull();
		layoutRow2.setFlexGrow(1.0, layoutRow4);
		layoutRow4.addClassName(Gap.MEDIUM);
		layoutRow4.setWidth("780px");
		layoutRow4.getStyle().set(style, "1");
		h4.setText("Credito virtuale:");
		layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h4);
		h4.setWidth(width);
		h6.setText(sd.getContoVirtuale(sd.getMatricola())+"€");
		layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, h6);
		h6.setWidth(width);
		layoutRow3.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow3);
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set(style, "1");
		layoutRow3.setAlignItems(Alignment.CENTER);
		layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
		buttonPrimary.setText("PAGA IN CASSA");
		layoutRow3.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
		String dimensioneBottone= "300px";
		buttonPrimary.setWidth(dimensioneBottone);
		buttonPrimary.setHeight(dimensioneBottone);
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutRow5.setHeightFull();
		layoutRow3.setFlexGrow(1.0, layoutRow5);
		layoutRow5.addClassName(Gap.MEDIUM);
		layoutRow5.setWidth("200px");
		layoutRow5.getStyle().set(style, "1");
		buttonPrimary2.setText("PAGA COL CREDITO VIRTUALE");
		layoutRow3.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary2);
		buttonPrimary2.setWidth(dimensioneBottone);
		buttonPrimary2.setHeight(dimensioneBottone);
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		getContent().add(h1);
		getContent().add(hr);
		getContent().add(textSmall);
		getContent().add(layoutColumn2);
		layoutColumn2.add(layoutRow);
		layoutRow.add(layoutRow2);
		layoutRow2.add(h4);
		layoutRow2.add(h6);
		layoutColumn2.add(layoutRow3);
		layoutRow3.add(buttonPrimary);
		layoutRow3.add(buttonPrimary2);
		
		
		//vai in cassa
		buttonPrimary.addClickListener(event -> UI.getCurrent().navigate("my-view8"));
		//pagamento virtuale
		buttonPrimary2.addClickListener(event -> {
			Connessione connessione = Connessione.getInstance();
			DSLContext dslContext = connessione.getDslContext();
			dslContext.update(Accountutenti.ACCOUNTUTENTI).set(Accountutenti.ACCOUNTUTENTI.CONTO,Accountutenti.ACCOUNTUTENTI.CONTO.add(c.elaboraPrezzoScontato(sd.getMatricola())))
			.where(Accountutenti.ACCOUNTUTENTI.MATRICOLA.eq(sd.getMatricola())).execute();
			UI.getCurrent().navigate("my-view8");});
	}
}
